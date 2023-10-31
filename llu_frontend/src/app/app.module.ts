import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {RouterModule} from "@angular/router";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { ClientListComponent } from './components/client-list/client-list.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { EventsPageComponent } from './components/events-page/events-page.component';
import { BusinessComponent } from './components/business/business.component';
import { RemoveSpacesPipe } from './pipes/remove-spaces.pipe';
import { ReactiveFormsModule } from '@angular/forms';
import { BusinessesComponent } from './components/businesses/businesses.component';
import { EditBusinessComponent } from './components/edit-business/edit-business.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientListComponent,
    NavbarComponent,
    EventsPageComponent,
    BusinessComponent,
    RemoveSpacesPipe,
    BusinessesComponent,
    EditBusinessComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
