package br.com.basis.prova.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "ALUNO")
@Getter
@Setter
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @Size(max = 6)
    @Column(name = "MATRICULA", nullable = false)
    private String matricula;

    @NotNull
    @Size(min = 11, max = 11)
    @Column(name = "CPF", nullable = false)
    @CPF
    private String cpf;

    @NotNull
    @Column(name = "NOME", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @ManyToMany
    @JoinTable(name = "ALUNO_DISCIPLINA",
            joinColumns = @JoinColumn(name = "ID_ALUNO", referencedColumnName = "ID"),
            inverseJoinColumns= @JoinColumn(name = "ID_DISCIPLINA", referencedColumnName = "ID"))
    private List<Disciplina> disciplinas = new ArrayList<>();

	public void setNome(String nomeAluno) {
		this.nome = nomeAluno;
	}

	public void setCpf(String cpfAluno) {
		this.cpf = cpfAluno;
	}

	public void setDataNascimento(LocalDate dataAluno) {
		this.dataNascimento = dataAluno;
	}

	public void setMatricula(String matriculaAluno) {
		this.matricula = matriculaAluno;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getMatricula() {
		return matricula;
	}

	
	public String getCpf() {
		return cpf;
	}

	@JsonIgnore
	public String getNome() {
		return nome;
	}

	@JsonIgnore
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

