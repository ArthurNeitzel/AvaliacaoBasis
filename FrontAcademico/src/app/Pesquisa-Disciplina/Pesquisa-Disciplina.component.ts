import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-Pesquisa-Disciplina',
  templateUrl: './Pesquisa-Disciplina.component.html',
  styleUrls: ['./Pesquisa-Disciplina.component.css']
})
export class PesquisaDisciplinaComponent {

  disciplinas = [
    {id: 1, nome: "POO", descricao: "Prog orientada a objetos", cargaHoraria: 60},
    {id: 2, nome: "P1", descricao: "Programacao 1", cargaHoraria: 60},
    {id: 3, nome: "BD", descricao: "Banco de Dados", cargaHoraria: 60},
  ]

}
