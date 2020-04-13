import { ProfessorService } from './../professor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-Pesquisa-Professor',
  templateUrl: './Pesquisa-Professor.component.html',
  styleUrls: ['./Pesquisa-Professor.component.css']
})
export class PesquisaProfessorComponent implements OnInit{

  constructor(private professorService: ProfessorService) {}
  professores = [];

  ngOnInit() {
    this.consultar();
  }
  consultar(){
    this.professorService.consultar()
      .then(retorno => {
        this.professores = retorno;
      })
  }
  excluir(matricula: number){
    this.professorService.excluir(matricula).then(
      () => {
        alert('Professor excluido.');
        this.consultar();
      }
    );
  }

  

}
