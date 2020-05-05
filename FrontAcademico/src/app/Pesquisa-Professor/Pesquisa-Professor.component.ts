import { ModalDetalhadoComponent } from "./../Modal-Detalhado/Modal-Detalhado.component";
import { ProfessorService } from "./../professor.service";
import { Component, OnInit } from "@angular/core";
import { DialogService } from "primeng/dynamicdialog";
import { DynamicDialogRef } from "primeng/dynamicdialog";

@Component({
  selector: "app-Pesquisa-Professor",
  templateUrl: "./Pesquisa-Professor.component.html",
  styleUrls: ["./Pesquisa-Professor.component.css"],
  providers: [DialogService],
})
export class PesquisaProfessorComponent implements OnInit {
  constructor(
    private professorService: ProfessorService,
    public dialogService: DialogService
  ) {}

  professores = [
    { id: 1, nome: "Arthur", area: "TI", dataNascimento: "01-01-2000" },
  ];

  ref: DynamicDialogRef;

  ngOnInit() {
    this.consultar();
  }
  consultar() {
    // this.professorService.consultar()
    //   .then(retorno => {
    //     this.professores = retorno;
    //   })
  }
  excluir(matricula: number) {
    this.professorService.excluir(matricula).then(() => {
      alert("Professor excluido.");
      this.consultar();
    });
  }
  mostrar() {
    this.ref = this.dialogService.open(ModalDetalhadoComponent, {
      header: "Detalhes",
      width: "70%",
      contentStyle: { "max-height": "350px", overflow: "auto" },
    });
  }
}
