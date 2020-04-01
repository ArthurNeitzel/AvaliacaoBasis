package br.com.basis.prova.dominio.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.dto.ProfessorDTO;
import br.com.basis.prova.dominio.dto.ProfessorDetalhadoDTO;

public class ConversorProfessor {
	
	
	
	public ConversorProfessor() {

	}

	public ProfessorDTO toProfessorDto(Professor prof) {
		ProfessorDTO novo = new ProfessorDTO();
		
		novo.setId(prof.getId());
		novo.setArea(prof.getArea());
		novo.setDataNascimento(prof.getDataNascimento());
		novo.setMatricula(prof.getMatricula());
		novo.setNome(prof.getNome());
		
		return novo;
	}
	
	public Professor toProfessor(ProfessorDTO prof) {
		Professor novo = new Professor();
		
		novo.setArea(prof.getArea());
		novo.setDataNascimento(prof.getDataNascimento());
		novo.setMatricula(prof.getMatricula());
		novo.setNome(prof.getNome());
		
		return novo;
	}
	
	public ProfessorDetalhadoDTO toProfessorDetalhadoDto(Professor prof) {
		ProfessorDetalhadoDTO novo = new ProfessorDetalhadoDTO();
		
		novo.setId(prof.getId());
		novo.setArea(prof.getArea());
		novo.setDataNascimento(prof.getDataNascimento());
		novo.setMatricula(prof.getMatricula());
		novo.setNome(prof.getNome());
		
		return novo;
	}
	
	public List<ProfessorDTO> toProfessorDtoList(List<Professor> profs){
		List<ProfessorDTO> lista = new ArrayList();;
		int i=0;
		System.out.println("professores: " + profs.size());
		for(i=0;i<profs.size();i++) {
			System.out.println("Professor: " + profs.get(i).getNome());
			lista.add(toProfessorDto(profs.get(i)));
		}
		return lista;
	}
}
