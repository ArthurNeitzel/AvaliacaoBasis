import { Professor } from './Model/Professor';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';




@Injectable({
  providedIn: 'root'
})

export class ProfessorService {

  constructor(private http: HttpClient) { }
  headers = new Headers();

  consultar(): Promise<any> {
     return this.http.get('http://localhost:8080/api/professores/')
     .toPromise()
  }

  adicionar(professor: any): Promise<any> {
    return this.http.post('http://localhost:8080/api/professores/', professor)
    .toPromise();
  }

  excluir(matricula: number): Promise<any>{
    return this.http.delete(`http://localhost:8080/api/professores/${matricula}`)
    .toPromise()
  }
}
