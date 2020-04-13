import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-Pesquisa-Aluno',
  templateUrl: './Pesquisa-Aluno.component.html',
  styleUrls: ['./Pesquisa-Aluno.component.css']
})
export class PesquisaAlunoComponent {

  alunos = [
    {id: 1, nome:"Arthur", idade:20, matricula:20171},
    {id: 2, nome:"Joao", idade:18, matricula:20171},
    {id: 3, nome:"Jose", idade:33, matricula:20171},
  ]

}
