import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AnimationFrameScheduler } from 'rxjs/internal/scheduler/AnimationFrameScheduler';

@Component({
  selector: 'app-AvaliacaoForm',
  templateUrl: './AvaliacaoForm.component.html',
  styleUrls: ['./AvaliacaoForm.component.css']
})
export class AvaliacaoFormComponent {

  discSelecionada: any;
  
  disciplinas = [
    {id: 1, nome: "POO", descricao: "Prog orientada a objetos", cargaHoraria: 60},
    {id: 2, nome: "P1", descricao: "Programacao 1", cargaHoraria: 60},
    {id: 3, nome: "BD", descricao: "Banco de Dados", cargaHoraria: 60},
  ]

  alunoSelecionado: any;
  
  alunos = [
    {id: 1, nome:"Arthur", cpf:123445, dataNascimento:"17/06/1999", matricula:20171},
    {id: 2, nome:"Joao", cpf:123445, dataNascimento:"17/06/1999", matricula:20171},
    {id: 3, nome:"Jose", cpf:123445, dataNascimento:"17/06/1999", matricula:20171},
  ]

}
