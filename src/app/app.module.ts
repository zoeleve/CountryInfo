import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CountryListComponent } from './country-list/country-list.component';
import { LanguageListComponent } from './language-list/language-list.component';
import { CountryDataComponent } from './country-data/country-data.component';

@NgModule({
  declarations: [
    AppComponent,
    CountryListComponent,
    LanguageListComponent,
    CountryDataComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }



