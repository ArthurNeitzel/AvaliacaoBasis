package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
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

    @Autowired
    private DisciplinaRepositorio disciplinaRepositorio;

    public Professor salvar(Professor professor) {
        professorRepositorio.save(professor);
        return professor;
    }

    public void excluir(String matricula) {
        Professor professor = consultarMatricula(matricula);
        List<Disciplina> disciplinas = disciplinaRepositorio.findByProfessor(professor);
        if(!disciplinas.isEmpty()) {
        	throw new RegraNegocioException("Professor possui materia em responsabilidade");
        }
        professorRepositorio.delete(professor);
    }

    public List<Professor> consultar() {
        return professorRepositorio.findAll();
    }
    
    
    public Professor consultarMatricula(String matricula) {
    	
    	return professorRepositorio.findByMatricula(matricula).orElseThrow(() -> new RegistroNaoEncontradoException("Registro nao encontrado"));
    	
    }

    public Professor detalhar(Integer id) {
        return new Professor();
    }

}
