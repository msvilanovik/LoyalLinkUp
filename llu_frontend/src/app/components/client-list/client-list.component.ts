import { Component, OnInit } from '@angular/core';
import { Business } from 'src/app/interfaces/business';
import { Client } from 'src/app/interfaces/client';
import { Event } from 'src/app/interfaces/event';
import { BusinessService } from 'src/app/services/business.service';
import { ClientService } from 'src/app/services/client.service';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {


  clients!: Client[] 

  businesses! : Business[]

  events! : Event[]


  constructor(private clientService: ClientService, private businessService: BusinessService, private eventService: EventService) { }

  ngOnInit(): void {

    this.getAllClients()
    this.getAllBusinesses()
    this.getAllEvents()
  }

  getAllClients(): void{
    this.clientService.getAllClients().subscribe((data) => {
      this.clients = data
    })
  }

  getAllBusinesses(): void{
    this.businessService.getAllBusinesses().subscribe((data) => {
      this.businesses = data
    })
  }

  getAllEvents(): void{
    this.eventService.getAllEvents().subscribe((data) => {
      this.events = data
    })
  }

}
