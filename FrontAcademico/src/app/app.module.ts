import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SideBarComponent } from './SideBar/SideBar.component';
import { ProfessorFormComponent } from './ProfessorForm/ProfessorForm.component';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import {TooltipModule} from 'primeng/tooltip';
import {DialogModule, Dialog} from 'primeng/dialog';
import {TabViewModule} from 'primeng/tabview';
import {CodeHighlighterModule} from 'primeng/codehighlighter';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { PesquisaProfessorComponent } from './Pesquisa-Professor/Pesquisa-Professor.component';
import { PesquisaDisciplinaComponent } from './Pesquisa-Disciplina/Pesquisa-Disciplina.component';
import { ModalDetalhadoComponent } from './Modal-Detalhado/Modal-Detalhado.component';


@NgModule({
   declarations: [
      AppComponent,
      SideBarComponent,
      ProfessorFormComponent,
      PesquisaProfessorComponent,
      PesquisaDisciplinaComponent,
      ModalDetalhadoComponent
   ],
   imports: [
      BrowserModule,
      BrowserAnimationsModule,
      AppRoutingModule,
      FormsModule,
      InputTextModule,
      ButtonModule,
      TableModule,
      TooltipModule,
      DialogModule,
      TabViewModule,
      CodeHighlighterModule
   ],
   providers: [],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
