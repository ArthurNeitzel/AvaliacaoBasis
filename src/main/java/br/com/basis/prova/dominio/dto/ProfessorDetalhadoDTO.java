package br.com.basis.prova.dominio.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.basis.prova.dominio.Disciplina;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProfessorDetalhadoDTO {
	private Integer id;
    private String nome;
    private String matricula;
    private String area;
    private LocalDate dataNascimento;
	private List<DisciplinaListagemDTO> disciplinas;
}
