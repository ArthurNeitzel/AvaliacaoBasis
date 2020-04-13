import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-Pesquisa-Avaliacao',
  templateUrl: './Pesquisa-Avaliacao.component.html',
  styleUrls: ['./Pesquisa-Avaliacao.component.css']
})
export class PesquisaAvaliacaoComponent {

    avaliacoes = [
      {id: 1, aluno: "Arthur", disciplina: "POO1", nota: 100},
      {id: 2, aluno: "Beatriz", disciplina: "POO1", nota: 100},
      {id: 3, aluno: "Raphaela", disciplina: "POO1", nota: 100},
      {id: 4, aluno: "Sandro", disciplina: "POO1", nota: 100},
    ]

}
