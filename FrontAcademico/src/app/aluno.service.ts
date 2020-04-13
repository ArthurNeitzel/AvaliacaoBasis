import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  constructor(private http: HttpClient) { }

  consultar(): Promise<any> {
     return this.http.get('http://localhost:8080/api/alunos/')
     .toPromise()
  }

  adicionar(aluno: any): Promise<any> {
    return this.http.post('http://localhost:8080/api/alunos/', aluno)
    .toPromise()
  }

  excluir(matricula: number): Promise<any>{
    return this.http.delete(`http://localhost:8080/api/alunos/${matricula}`)
    .toPromise()
  }

}
