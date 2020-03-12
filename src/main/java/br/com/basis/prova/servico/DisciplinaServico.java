package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.repositorio.ProfessorRepositorio;
import br.com.basis.prova.servico.exception.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DisciplinaServico {
	
	@Autowired
    private DisciplinaRepositorio disciplinaRepositorio;


    @Autowired
    private ProfessorRepositorio professorRepositorio;


    public Disciplina salvar(Disciplina disciplina) {
        disciplinaRepositorio.save(disciplina);
        return disciplina;
    }

    public void excluir(Integer id) {
    }

    public List<Disciplina> consultar() {
        return disciplinaRepositorio.findAll();
    }

    public Disciplina detalhar(Integer id) {
        return new Disciplina();
    }

}
