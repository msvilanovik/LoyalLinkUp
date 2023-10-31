import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Address } from 'src/app/interfaces/address';
import { Business } from 'src/app/interfaces/business';
import { BusinessService } from 'src/app/services/business.service';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-edit-business',
  templateUrl: './edit-business.component.html',
  styleUrls: ['./edit-business.component.css']
})
export class EditBusinessComponent implements OnInit {

  editForm! : FormGroup
  business! : Business
  typeOfBusinesses! : Array<String>
  address! : Address
  businessToEdit! : Business

  constructor(private businessService: BusinessService, private route: ActivatedRoute, private eventService: EventService, private router: Router) { }

  ngOnInit(): void {

    this.loadBusiness(this.restoreSpaces(this.route.snapshot.paramMap.get("name")!))
    this.listTypeOfBusinesses()

  }

  loadBusiness(name: string){
    this.businessService.getBusinessByName(name).subscribe(data => {
       this.business = data
       
    

    this.editForm = new FormGroup({
      name : new FormControl(this.business.name),
      city : new FormControl(this.business.address.city_name),
      street_name : new FormControl(this.business.address.street_name),
      street_number : new FormControl(this.business.address.street_number),
      type_of_business : new FormControl(this.business.type_of_business),
      phone_number : new FormControl(this.business.phone_number)
    })
    })
    
  }

  restoreSpaces(name : string) : string {
    
    return name.replace(/_/g, ' ');
  }
  editBusiness(){

    console.log(this.editForm.value)

    this.address.city_name = this.editForm.value.city
    this.address.street_name = this.editForm.value.street_name
    this.address.street_number = this.editForm.value.street_number
    
    this.businessService.editBusiness(this.business.id,this.editForm.value)
    
    this.router.navigateByUrl(`/business/${this.business.name}`)
  
  }

  listTypeOfBusinesses(){
    this.businessService.listTypeOfBusinesses().subscribe(data => { this.typeOfBusinesses = data})
  }
}
