import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Address } from '../interfaces/address';
import { Business } from '../interfaces/business';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  url = "api/address"

  constructor(private http: HttpClient) { }
  

  
  getAllAddresses() : Observable<Address[]> {
    return this.http.get<Address[]>(this.url)
  }

  getAddressById(id: number) : Observable<Address>{
    return this.http.get<Address>(this.url.concat(`/${id}`))
  }

  deleteAddressById(id: number) : void{
    this.http.delete(this.url.concat(`/delete/${id}`)).subscribe()
  }


  createAddress(address: Address): void {
    this.http.post(this.url.concat(`/add`), {
      street_name: address.street_name,
      city_name: address.city_name,
      street_number: address.street_number
    }).subscribe(data => {
      tap(data)
    })
  }

  editAddress(id: number, address: Address): void {
    this.http.put(this.url.concat(`/edit/${id}`), {
      street_name: address.street_name,
      city_name: address.city_name,
      street_number: address.street_number
    }).subscribe(data => {
      tap(data)
    })
  }
}
