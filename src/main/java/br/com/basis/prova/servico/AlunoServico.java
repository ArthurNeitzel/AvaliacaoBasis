package br.com.basis.prova.servico;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.conversor.ConversorAluno;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
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
	
	private ConversorAluno conversoraluno = new ConversorAluno();


    public AlunoDTO salvar(AlunoDTO aluno) {
    	
        if(verificarCPF(conversoraluno.toAluno(aluno))){
            throw new RegraNegocioException("CPF já existe");
        }
        
        Aluno novo = alunoRepositorio.save(conversoraluno.toAluno(aluno));
        aluno.setId(novo.getId());
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

    public List<AlunoListagemDTO> consultar() {
        return conversoraluno.toAlunoListagemDTOList(alunoRepositorio.findAll());
    }

    public AlunoDetalhadoDTO detalhar(Integer id) {
        AlunoDetalhadoDTO aluno = conversoraluno.toAlunoDetalhadoDTO(alunoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Registro não encontrado")));
        return aluno;
    }
    
    public Aluno consultarMatricula(String matricula) {
    	return alunoRepositorio.findByMatricula(matricula).orElseThrow(() -> new RegistroNaoEncontradoException("Aluno nao encontrado"));
    }

}
