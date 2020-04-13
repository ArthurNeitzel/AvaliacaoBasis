import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'

@Component({
  selector: 'app-DisciplinaForm',
  templateUrl: './DisciplinaForm.component.html',
  styleUrls: ['./DisciplinaForm.component.css']
})
export class DisciplinaFormComponent{

  selectedValue : Number;
  profSelecionado : any;
  professores = [
    {id: 1,nome: 'Arthur',matricula: 20171,area: 'TI',dataNascimento: '01/01/2000'},
    {id: 2,nome: 'Joao',matricula: 20171,area: 'TI',dataNascimento: '01/01/2000'},
    {id: 3,nome: 'Jose',matricula: 20171,area: 'TI',dataNascimento: '01/01/2000'}
  ]

}
