package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
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


    public Disciplina salvar(Disciplina disciplina) {
    	professorRepositorio.findById(disciplina.getProfessor().getId()).orElseThrow(() -> new RegistroNaoEncontradoException("Professor não encontrado"));
        disciplinaRepositorio.save(disciplina);
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
    
    public List<Disciplina> consultar() {
        return disciplinaRepositorio.findAll();
    }

    public Disciplina detalhar(Integer id) {
        return new Disciplina();
    }

}
