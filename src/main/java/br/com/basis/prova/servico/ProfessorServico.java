package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.conversor.ConversorDisciplina;
import br.com.basis.prova.dominio.conversor.ConversorProfessor;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import br.com.basis.prova.servico.exception.RegistroNaoEncontradoException;
import br.com.basis.prova.servico.exception.RegraNegocioException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfessorServico {
	
	@Autowired
    private ProfessorRepositorio professorRepositorio;
	
	
	private ConversorProfessor conversorProfessor = new ConversorProfessor();
	private ConversorDisciplina conversorDisciplina = new ConversorDisciplina();

    @Autowired
    private DisciplinaRepositorio disciplinaRepositorio;

    public ProfessorDTO salvar(ProfessorDTO professorDTO) {
        Professor inserido = professorRepositorio.save(conversorProfessor.toProfessor(professorDTO));
        professorDTO.setId(inserido.getId());
        return professorDTO;
    }

    public void excluir(String matricula) {
        Professor professor = consultarMatricula(matricula);
        List<Disciplina> disciplinas = disciplinaRepositorio.findByProfessor(professor);
        if(!disciplinas.isEmpty()) {
        	throw new RegraNegocioException("Professor possui materia em responsabilidade");
        }
        professorRepositorio.delete(professor);
    }

    public List<ProfessorDTO> consultar() {
        return conversorProfessor.toProfessorDtoList(professorRepositorio.findAll());
    }
    
    
    public Professor consultarMatricula(String matricula) {
    	
    	return professorRepositorio.findByMatricula(matricula).orElseThrow(() -> new RegistroNaoEncontradoException("Registro nao encontrado"));
    	
    }

    public Professor consultarId(Integer id) {
    	
    	return professorRepositorio.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Registro nao encontrado"));
    	
    }

    public ProfessorDetalhadoDTO detalhar(Integer id) {
    	Professor search = consultarId(id);
    	ProfessorDetalhadoDTO professorD = conversorProfessor.toProfessorDetalhadoDto(search);
    	professorD.setDisciplinas(conversorDisciplina.toDisciplinaDTOList(disciplinaRepositorio.findByProfessor(search)));
    	
    	return professorD;
    }

}
