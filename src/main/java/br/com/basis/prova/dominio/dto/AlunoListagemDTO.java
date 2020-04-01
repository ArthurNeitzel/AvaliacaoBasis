package br.com.basis.prova.dominio.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;

@NoArgsConstructor
@Getter
@Setter
public class AlunoListagemDTO { // DTO usado para consulta simples de alunos

    private Integer id;
    private String nome;
    private String matricula;
    @JsonIgnore
    private LocalDate dataNascimento;
    private Integer idade;
    
    
    public void calculaIdade(LocalDate dataNasc) {
    	ZoneId defaultZoneId = ZoneId.systemDefault();
    	Date dateN = (Date) Date.from(dataNasc.atStartOfDay(defaultZoneId).toInstant());
        Calendar dataNascimento = Calendar.getInstance();  
        dataNascimento.setTime(dateN); 
        Calendar hoje = Calendar.getInstance();  

        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR); 

        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
          idade--;  
        } 
        else 
        { 
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--; 
            }
        }

        this.idade = idade;
    }

}
