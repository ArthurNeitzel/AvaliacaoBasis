package br.com.basis.prova.dominio.auxiliar;

import java.util.List;
import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.Disciplina;

public class ProfessorDetalhado {
	
	private Professor professor;
	private List<Disciplina> disciplinas;
	
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
}
