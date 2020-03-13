package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.servico.exception.RegistroNaoEncontradoException;
import br.com.basis.prova.servico.exception.RegraNegocioException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AlunoServico {
	
	@Autowired
    private AlunoRepositorio alunoRepositorio;


    public Aluno salvar(Aluno aluno) {
    	
        if(verificarCPF(aluno)){
            throw new RegraNegocioException("CPF já existe");
        }
        
        alunoRepositorio.save(aluno);

        return aluno;
    }

    private boolean verificarCPF(Aluno aluno) {
        Aluno alunoCpf = alunoRepositorio.findByCpf(aluno.getCpf());
        return !(alunoCpf == null || alunoCpf.getId().equals(aluno.getId()));
    }

    public void excluir(String matricula) {
    	Aluno deletar = consultarMatricula(matricula);
    	
    	if(!deletar.getDisciplinas().isEmpty()) {
    		throw new RegraNegocioException("Aluno esta matriculado em disciplinas");
    	}
    	
    	alunoRepositorio.delete(deletar);
    }

    public List<Aluno> consultar() {
        return alunoRepositorio.findAll();
    }

    public Aluno detalhar(Integer id) {
        Aluno aluno = alunoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Registro não encontrado"));
        return aluno;
    }
    
    public Aluno consultarMatricula(String matricula) {
    	return alunoRepositorio.findByMatricula(matricula).orElseThrow(() -> new RegistroNaoEncontradoException("Aluno nao encontrado"));
    }

}
