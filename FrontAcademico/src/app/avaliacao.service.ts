import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AvaliacaoService {

  constructor(private http: HttpClient) { }

  consultar(): Promise<any> {
     return this.http.get('http://localhost:8080/api/avaliacoes/')
     .toPromise()
  }

  adicionar(avaliacao: any): Promise<any> {
    return this.http.post('http://localhost:8080/api/alunos/', avaliacao)
    .toPromise()
  }

}
