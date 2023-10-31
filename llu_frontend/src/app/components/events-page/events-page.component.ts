import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { BehaviorSubject, map, Observable, switchMap, tap } from 'rxjs';
import { Address } from 'src/app/interfaces/address';
import { Event } from 'src/app/interfaces/event';
import { AddressService } from 'src/app/services/address.service';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-events-page',
  templateUrl: './events-page.component.html',
  styleUrls: ['./events-page.component.css']
})
export class EventsPageComponent implements OnInit {

  addresses! : Address[]
  typeOfEvents! : String[]
  events! : Event[]


  subject$ = new BehaviorSubject<boolean>(true)

  filterForm = new FormGroup({
    city: new FormControl('Choose a city'),
    type: new FormControl('Choose a type of event')
  })

  constructor(private addressService: AddressService,private eventService: EventService) { }

  ngOnInit(): void {

    this.getAllAddresses()
    this.getAllTypeOfEvents()
    this.getAllEvents()

  }

  getAllAddresses(): void{
    this.addressService.getAllAddresses().subscribe((data) => {
      this.addresses = data
    })
  }

  getAllTypeOfEvents() {
    this.eventService.getAllTypeOfEvents().subscribe(data => {
      this.typeOfEvents = data
    })
  }

  getAllEvents() { 

  this.eventService.getAllEvents().subscribe(data => {this.events = data})
  }

  filter() {


    this.eventService.filterEventsByCityAndtype(this.filterForm.value.city!,this.filterForm.value.type!)
    .subscribe(data => {this.events = data})
  }
}
