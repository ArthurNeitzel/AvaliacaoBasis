import { AvaliacaoService } from "./avaliacao.service";
import { DisciplinaService } from "./disciplina.service";
import { AlunoService } from "./aluno.service";
import { ProfessorService } from "./professor.service";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { FormsModule } from "@angular/forms";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { SideBarComponent } from "./SideBar/SideBar.component";
import { ProfessorFormComponent } from "./ProfessorForm/ProfessorForm.component";
import { InputTextModule } from "primeng/inputtext";
import { ButtonModule } from "primeng/button";
import { TableModule } from "primeng/table";
import { TooltipModule } from "primeng/tooltip";
import { DialogModule, Dialog } from "primeng/dialog";
import { TabViewModule } from "primeng/tabview";
import { CodeHighlighterModule } from "primeng/codehighlighter";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MultiSelectModule } from "primeng/multiselect";
import { RadioButtonModule } from "primeng/radiobutton";
import { DropdownModule } from "primeng/dropdown";
import { InputMaskModule } from "primeng/inputmask";
import { CalendarModule } from "primeng/calendar";
import { DynamicDialogModule } from "primeng/dynamicdialog";

import { PesquisaProfessorComponent } from "./Pesquisa-Professor/Pesquisa-Professor.component";
import { PesquisaDisciplinaComponent } from "./Pesquisa-Disciplina/Pesquisa-Disciplina.component";
import { ModalDetalhadoComponent } from "./Modal-Detalhado/Modal-Detalhado.component";
import { AlunoFormComponent } from "./AlunoForm/AlunoForm.component";
import { DisciplinaFormComponent } from "./DisciplinaForm/DisciplinaForm.component";
import { AvaliacaoFormComponent } from "./AvaliacaoForm/AvaliacaoForm.component";
import { PesquisaAlunoComponent } from "./Pesquisa-Aluno/Pesquisa-Aluno.component";
import { PesquisaAvaliacaoComponent } from "./Pesquisa-Avaliacao/Pesquisa-Avaliacao.component";
import { ErrorHandlerService } from "./errorHandler.service";

const routes: Routes = [
  { path: "alunos", component: PesquisaAlunoComponent },
  { path: "alunos/novo", component: AlunoFormComponent },
  { path: "professores", component: PesquisaProfessorComponent },
  { path: "professores/novo", component: ProfessorFormComponent },
  { path: "disciplinas", component: PesquisaDisciplinaComponent },
  { path: "disciplinas/novo", component: DisciplinaFormComponent },
  { path: "avaliacoes", component: PesquisaAvaliacaoComponent },
  { path: "avaliacoes/novo", component: AvaliacaoFormComponent },
  { path: "detalhar", component: ModalDetalhadoComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    SideBarComponent,
    ProfessorFormComponent,
    PesquisaProfessorComponent,
    PesquisaDisciplinaComponent,
    ModalDetalhadoComponent,
    AlunoFormComponent,
    DisciplinaFormComponent,
    AvaliacaoFormComponent,
    PesquisaAlunoComponent,
    PesquisaAvaliacaoComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes),
    InputTextModule,
    ButtonModule,
    TableModule,
    TooltipModule,
    DialogModule,
    TabViewModule,
    CodeHighlighterModule,
    MultiSelectModule,
    RadioButtonModule,
    DropdownModule,
    InputMaskModule,
    CalendarModule,
    DynamicDialogModule,
    HttpClientModule,
  ],
  providers: [
    ProfessorService,
    AlunoService,
    DisciplinaService,
    AvaliacaoService,
    ErrorHandlerService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
