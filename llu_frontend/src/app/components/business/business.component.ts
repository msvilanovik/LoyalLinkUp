import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Business } from 'src/app/interfaces/business';
import { Event } from 'src/app/interfaces/event';
import { BusinessService } from 'src/app/services/business.service';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-business',
  templateUrl: './business.component.html',
  styleUrls: ['./business.component.css']
})
export class BusinessComponent implements OnInit {

  business! : Business
  events! : Event[]

  constructor(private businessService: BusinessService, private eventService: EventService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    
    
    this.getBusinessByName(this.restoreSpaces(this.route.snapshot.paramMap.get("name")!))
  }

  getABusinessById(id: number) {
    this.businessService.getBusinessById(id).subscribe(data => { this.business = data})
  }

  getEventsByBusinessId(id: number) {
    return this.eventService.getAllEventsByBusinessId(id).subscribe(data => {this.events = data})
  }

  getBusinessByName(name :string){
    return this.businessService.getBusinessByName(name).subscribe(data => { 
      this.business = data     
      this.getEventsByBusinessId(this.business.id)})
  }

  restoreSpaces(name : string) : string {
    return name.replace(/_/g, ' ');
  }
  
  editBusiness(){
    
  }
}
