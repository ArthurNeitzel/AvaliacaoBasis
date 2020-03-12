package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        Professor professor = new Professor();
        List<Disciplina> disciplinas = disciplinaRepositorio.findByProfessor(professor);
    }

    public List<Professor> consultar() {
        return new ArrayList<>();
    }

    public Professor detalhar(Integer id) {
        return new Professor();
    }

}
