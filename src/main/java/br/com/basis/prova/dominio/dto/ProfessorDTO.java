package br.com.basis.prova.dominio.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProfessorDTO {
    private Integer id;
    private String nome;
    private String matricula;
    private String area;
    private LocalDate dataNascimento;
}
