package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AlunoDTO { // DTO usado para salvar e editar um aluno

    private Integer id;
    private String nome;
    private String cpf;
    private String matricula;
    private LocalDate dataNascimento;
    private List<DisciplinaDTO> disciplinas = new ArrayList<>();
	
    
    public String getId() {
		return this.getId();
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public List<DisciplinaDTO> getDisciplinas() {
		return disciplinas;
	}


	public void setDisciplinas(List<DisciplinaDTO> disciplinas) {
		this.disciplinas = disciplinas;
	}


	public void setId(Integer id) {
		this.id = id;
	}

}
