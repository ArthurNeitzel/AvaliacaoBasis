package br.com.basis.prova.dominio.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import lombok.NoArgsConstructor;


@NoArgsConstructor

public class ConversorAluno {
	
	private ConversorDisciplina disciplinaconversor = new ConversorDisciplina();
	
	public AlunoDTO toAlunoDTO(Aluno aluno) {
		AlunoDTO retorno = new AlunoDTO();
		
		retorno.setId(aluno.getId());
		retorno.setCpf(aluno.getCpf());
		retorno.setDataNascimento(aluno.getDataNascimento());
		retorno.setMatricula(aluno.getMatricula());
		retorno.setNome(aluno.getNome());
		retorno.setDisciplinas(aluno.getDisciplinas());
		
		return retorno;
		
	}
	
	public Aluno toAluno(AlunoDTO aluno) {
		Aluno retorno = new Aluno();
		
		retorno.setCpf(aluno.getCpf());
		retorno.setDataNascimento(aluno.getDataNascimento());
		retorno.setMatricula(aluno.getMatricula());
		retorno.setNome(aluno.getNome());
		retorno.setDisciplinas(aluno.getDisciplinas());
		
		return retorno;
		
	}
	
	public AlunoListagemDTO toAlunoListagemDTO(Aluno aluno) {
		AlunoListagemDTO retorno = new AlunoListagemDTO();
		
		retorno.setId(aluno.getId());
		retorno.setDataNascimento(aluno.getDataNascimento());
		retorno.setMatricula(aluno.getMatricula());
		retorno.setNome(aluno.getNome());
		retorno.calculaIdade(retorno.getDataNascimento());
		
		return retorno;
		
	}
	
	public List<AlunoListagemDTO> toAlunoListagemDTOList(List<Aluno> alunos){
		List<AlunoListagemDTO> lista = new ArrayList();
		int i;
		for(i=0;i<alunos.size();i++) {
			lista.add(toAlunoListagemDTO(alunos.get(i)));
		}
		return lista;
		
	}
	
	public AlunoDetalhadoDTO toAlunoDetalhadoDTO(Aluno aluno) {
		AlunoDetalhadoDTO retorno = new AlunoDetalhadoDTO();
		
		retorno.setId(aluno.getId());
		retorno.setMatricula(aluno.getMatricula());
		retorno.setNome(aluno.getNome());
		retorno.setDisciplinas(disciplinaconversor.toDisciplinaDTOList(aluno.getDisciplinas()));
		
		return retorno;
		
	}
}

