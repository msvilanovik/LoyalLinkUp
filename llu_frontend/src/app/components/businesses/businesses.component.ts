import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { BehaviorSubject, debounceTime, distinctUntilChanged, Observable, switchMap } from 'rxjs';
import { Business } from 'src/app/interfaces/business';
import { BusinessService } from 'src/app/services/business.service';

@Component({
  selector: 'app-businesses',
  templateUrl: './businesses.component.html',
  styleUrls: ['./businesses.component.css']
})
export class BusinessesComponent implements OnInit {


  businesses$! : Observable<Business[]>
  businesses!: Business[]

  searchForm = new FormGroup({
    term: new FormControl('')
  })
  searchSubject$ = new BehaviorSubject<string>('')


  constructor(private businessService: BusinessService) { }

  ngOnInit(): void {
  
    this.businesses$ = this.searchSubject$.pipe(
      debounceTime(200),
      distinctUntilChanged(),
      switchMap((term: string) => this.businessService.searchByName(term))
    )
    
    this.businesses$.subscribe(data => this.businesses = data)
    this.loadAllBusinesses()
  }

  loadAllBusinesses() {
     this.businesses$ = this.businessService.getAllBusinesses()
  }

  search(){
    this.searchSubject$.next(this.searchForm.value.term!)
  }

}
