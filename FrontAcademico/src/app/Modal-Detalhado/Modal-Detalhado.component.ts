import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-Modal-Detalhado',
  templateUrl: './Modal-Detalhado.component.html',
  styleUrls: ['./Modal-Detalhado.component.css']
})
export class ModalDetalhadoComponent {

  displayModal: boolean = true;
  professor = {id : 1, nome: "Arthur", matricula: 2041, disciplinas: "POO,PROG1,BD"}
  showDialog() {
      this.displayModal = true;
  }
}
