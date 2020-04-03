import { Component, OnInit, EventEmitter, Output } from '@angular/core';


@Component({
  selector: 'app-ProfessorForm',
  templateUrl: './ProfessorForm.component.html',
  styleUrls: ['./ProfessorForm.component.css']
})
export class ProfessorFormComponent {

  nome = 'Test';
  adicionado = false;
  @Output() funcionarioAdicionado = new EventEmitter();
  ultimoId = 0;

  adicionar(){
    this.adicionado = true;
    const funcionario = {
      id : ++this.ultimoId,
      nome: this.nome
    };

    this.funcionarioAdicionado.emit(funcionario);

  }

}
