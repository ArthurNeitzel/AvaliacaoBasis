package br.com.basis.prova.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.repositorio.AlunoRepositorio;
import br.com.basis.prova.repositorio.AvaliacaoRepositorio;
import br.com.basis.prova.repositorio.DisciplinaRepositorio;
import br.com.basis.prova.servico.exception.RegistroNaoEncontradoException;

@Service
@Transactional
public class AvaliacaoServico {
	
	@Autowired
    private AlunoRepositorio alunoRepositorio;
	
	@Autowired
    private DisciplinaRepositorio disciplinaRepositorio;
	
	@Autowired
    private AvaliacaoRepositorio avaliacaoRepositorio;
	
	public Avaliacao salvar(Avaliacao avaliacao) {
		disciplinaRepositorio.findById(avaliacao.getDisciplina().getId()).orElseThrow(() -> new RegistroNaoEncontradoException("Não encontrado disciplina"));
		alunoRepositorio.findById(avaliacao.getAluno().getId()).orElseThrow(() -> new RegistroNaoEncontradoException("Aluno não encontrado"));
		
		avaliacaoRepositorio.save(avaliacao);
		
		return avaliacao;
	}
	
	public List<Avaliacao> consultaAluno(Integer id){
		alunoRepositorio.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Aluno não encontrado"));
		Aluno aluno = alunoRepositorio.findById(id).get();
		return avaliacaoRepositorio.findByAluno(aluno);
	}
	
	public List<Avaliacao> consultaDisciplina(Integer id){
		disciplinaRepositorio.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Não encontrado disciplina"));
		
		Disciplina disciplina = disciplinaRepositorio.findById(id).get();
		
		return avaliacaoRepositorio.findByDisciplina(disciplina);
	}

	public Avaliacao consultar(Integer id) {
		return avaliacaoRepositorio.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Avaliacao não encontrada"));
	}
	
}
