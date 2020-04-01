package br.com.basis.prova.dominio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.basis.prova.dominio.Disciplina;

@NoArgsConstructor
@Getter
@Setter
public class AlunoDTO { // DTO usado para salvar e editar um aluno

    private Integer id;
    private String nome;
    private String cpf;
    private String matricula;
    private LocalDate dataNascimento;
    private List<Disciplina> disciplinas = new ArrayList<>();

}
