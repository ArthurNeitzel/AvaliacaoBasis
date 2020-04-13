package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.conversor.ConversorDisciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaListagemDTO;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import br.com.basis.prova.servico.exception.RegistroNaoEncontradoException;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DisciplinaServico {
	
	@Autowired
    private DisciplinaRepositorio disciplinaRepositorio;


    @Autowired
    private ProfessorRepositorio professorRepositorio;
    
    @Autowired
    private AlunoRepositorio alunoRepositorio;
    
    private ConversorDisciplina conversorDisciplina = new ConversorDisciplina();


    public DisciplinaDTO salvar(DisciplinaDTO disciplina) {
    	professorRepositorio.findById(disciplina.getProfessor().getId()).orElseThrow(() -> new RegistroNaoEncontradoException("Professor não encontrado"));
        Disciplina nova = disciplinaRepositorio.save(conversorDisciplina.toDisciplina(disciplina));
        disciplina.setId(nova.getId());
        return disciplina;
    }

    public void excluir(Integer id) {
    	Disciplina disciplina = consultarId(id);
        List<Aluno> alunos = alunoRepositorio.findByDisciplinas(disciplina);
        if(!alunos.isEmpty()) {
        	throw new RegraNegocioException("Disciplina possui alunos matriculados");
        }
        
        disciplinaRepositorio.delete(disciplina);
    }

    public Disciplina consultarId(Integer id) {
    	
    	return disciplinaRepositorio.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Disciplina não encontrada"));
    	
    }
    
    public List<DisciplinaListagemDTO> consultar() {
        return conversorDisciplina.toDisciplinaDTOList(disciplinaRepositorio.findAll());
    }

    public DisciplinaDetalhadaDTO detalhar(Integer id) {
    	DisciplinaDetalhadaDTO busca = conversorDisciplina.toDisciplinaDetalhadaDTO(this.consultarId(id));
    	return busca;
    }

}
