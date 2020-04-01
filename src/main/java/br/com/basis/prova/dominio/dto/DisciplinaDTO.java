package br.com.basis.prova.dominio.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.basis.prova.dominio.Professor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDTO {
    private Integer id;
    
    private String nome;

	
    private String descricao;
	
	
    private Integer cargaHoraria;
	
	
    private Integer ativa;
	
    private Professor professor;
}
