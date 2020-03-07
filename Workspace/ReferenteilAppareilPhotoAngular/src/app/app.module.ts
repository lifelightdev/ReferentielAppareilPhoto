import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppareilFormComponent } from './appareil-form/appareil-form.component';
import { AppareilServiceService } from './appareil-service.service';
import { AppareilListComponent } from './appareil-list/appareil-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AppareilListComponent,
    AppareilFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AppareilServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
