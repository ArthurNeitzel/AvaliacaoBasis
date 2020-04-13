import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DisciplinaService {

  constructor(private http: HttpClient) { }

  consultar(): Promise<any> {
     return this.http.get('http://localhost:8080/api/disciplinas/')
     .toPromise()
  }

  adicionar(disciplina: any): Promise<any> {
    return this.http.post('http://localhost:8080/api/disciplinas/', disciplina)
    .toPromise()
  }

  excluir(id: number): Promise<any>{
    return this.http.delete(`http://localhost:8080/api/disciplinas/${id}`)
    .toPromise()
  }

}
