import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-Pesquisa-Professor',
  templateUrl: './Pesquisa-Professor.component.html',
  styleUrls: ['./Pesquisa-Professor.component.css']
})
export class PesquisaProfessorComponent{

  professores = [
    {id: 1,nome: 'Arthur',matricula: 20171,area: 'TI',dataNascimento: '01/01/2000'},
    {id: 2,nome: 'Joao',matricula: 20171,area: 'TI',dataNascimento: '01/01/2000'},
    {id: 3,nome: 'Jose',matricula: 20171,area: 'TI',dataNascimento: '01/01/2000'}
  ]

}
