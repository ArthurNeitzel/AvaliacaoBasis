package br.com.basis.prova.dominio.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.dominio.dto.DisciplinaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaDetalhadaDTO;
import br.com.basis.prova.dominio.dto.DisciplinaListagemDTO;
import br.com.basis.prova.dominio.dto.ProfessorDTO;

public class ConversorDisciplina {

	public ConversorDisciplina() {
		
	}
	
	
	public DisciplinaDTO toDisciplinaDTO(Disciplina disc) {
		DisciplinaDTO nova = new DisciplinaDTO();
		
		nova.setId(disc.getId());
		nova.setAtiva(disc.getAtiva());
		nova.setCargaHoraria(disc.getCargaHoraria());
		nova.setDescricao(disc.getDescricao());
		nova.setNome(disc.getNome());
		nova.setProfessor(disc.getProfessor());
		
		return nova;
	}
	
	public Disciplina toDisciplina(DisciplinaDTO disc) {
		Disciplina nova = new Disciplina();
		
		nova.setId(disc.getId());
		nova.setAtiva(disc.getAtiva());
		nova.setCargaHoraria(disc.getCargaHoraria());
		nova.setDescricao(disc.getDescricao());
		nova.setNome(disc.getNome());
		nova.setProfessor(disc.getProfessor());
		
		return nova;
	}
	
	public DisciplinaDetalhadaDTO toDisciplinaDetalhadaDTO(Disciplina disc) {
		DisciplinaDetalhadaDTO nova = new DisciplinaDetalhadaDTO();
		
		nova.setId(disc.getId());
		nova.setAtiva(disc.getAtiva());
		nova.setCargaHoraria(disc.getCargaHoraria());
		nova.setDescricao(disc.getDescricao());
		nova.setNome(disc.getNome());
		nova.setProfessor(disc.getProfessor());
		
		return nova;
	}
	
	public DisciplinaListagemDTO toDisciplinaDTOL(Disciplina disc) {
		DisciplinaListagemDTO nova = new DisciplinaListagemDTO();
		
		nova.setId(disc.getId());
		nova.setCargaHoraria(disc.getCargaHoraria());
		nova.setDescricao(disc.getDescricao());
		nova.setNome(disc.getNome());
		
		return nova;
	}
	
	public List<DisciplinaListagemDTO> toDisciplinaDTOList(List<Disciplina> disciplinas){
		List<DisciplinaListagemDTO> lista = new ArrayList();
		int i;
		for(i=0;i<disciplinas.size();i++) {
			lista.add(toDisciplinaDTOL(disciplinas.get(i)));
		}
		
		return lista;
	}
	
}
