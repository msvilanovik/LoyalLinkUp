import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Event } from '../interfaces/event';

@Injectable({
  providedIn: 'root'
})
export class EventService {


  url = "api/event"

  constructor(private http: HttpClient) { }
  

 
  getAllEvents() : Observable<Event[]> {
    return this.http.get<Event[]>(this.url)
  }

  getEventById(id: number) : Observable<Event>{
    return this.http.get<Event>(this.url.concat(`/${id}`))
  }

  deleteEventById(id: number) : void{
    this.http.delete(this.url.concat(`/delete/${id}`)).subscribe()
  }

  createEvent(event: Event): void {
    this.http.post(this.url.concat(`/add`), {
      name: event.name,
      date_time : event.date_time,
      type_of_event: event.type_of_event,
      capacity: event.capacity,
      business: event.business.id
    }).subscribe(data => {
      tap(data)
    })
  }

  editEvent(id: number, event: Event): void {
    this.http.put(this.url.concat(`/edit/${id}`), {
      name: event.name,
      date_time : event.date_time,
      type_of_event: event.type_of_event,
      capacity: event.capacity,
      business: event.business.id
    }).subscribe(data => {
      tap(data)
    })

}
getAllTypeOfEvents() : Observable<String[]> {
  return this.http.get<String[]>(this.url.concat('/types'))
}


getAllEventsByBusinessId(id: number): Observable<Event[]>{
  return this.http.get<Event[]>(this.url.concat(`/business/${id}`))
}


filterEventsByCityAndtype(city: string, type: string) : Observable<Event[]> {
  return this.http.get<Event[]>(this.url.concat('/filter'), {
    params : {
      city: city,
      type: type
    }
  })
}






}

