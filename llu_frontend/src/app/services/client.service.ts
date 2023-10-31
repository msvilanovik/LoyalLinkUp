import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Client } from '../interfaces/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  url = "api/client"

  constructor(private http : HttpClient) { }


  getAllClients() : Observable<Client[]> {
    return this.http.get<Client[]>(this.url)
  }

  getClientById(id: number) : Observable<Client>{
    return this.http.get<Client>(this.url.concat(`/${id}`))
  }

  deleteClientById(id: number) : void{
    this.http.delete(this.url.concat(`/delete/${id}`)).subscribe()
  }

  createClient(client: Client): void {
    this.http.post(this.url.concat(`/add`), {
      name: client.name,
      surname: client.surname,
      phone_number: client.phone_number
    }).subscribe(data => {
      tap(data)
    })
  }

  editClient(id: number, client: Client): void {
    this.http.put(this.url.concat(`/edit/${id}`), {
      name: client.name,
      surname: client.surname,
      phone_number: client.phone_number
    }).subscribe(data => {
      tap(data)
    })
  }
}
