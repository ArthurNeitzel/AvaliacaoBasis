import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { NgForm, FormControl } from '@angular/forms'
import { ProfessorService } from './../professor.service';
import { Professor } from '../Model/Professor';


@Component({
  selector: 'app-ProfessorForm',
  templateUrl: './ProfessorForm.component.html',
  styleUrls: ['./ProfessorForm.component.css']
})
export class ProfessorFormComponent {

  constructor(private professorService: ProfessorService) {}

  
  nome: String;
  matricula: number;
  area: String;
  dataNascimento : Date;
  professor = new Professor();

  salvar(entrada : NgForm){
    
    
    this.professorService.adicionar(this.professor)
    .then((response : any) => alert(`Professor ${response.nome} criado com codigo: ${response.id}.`));

    entrada.resetForm();
  }

}
