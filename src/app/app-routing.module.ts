import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CountryListComponent } from './country-list/country-list.component';
import { LanguageListComponent } from './language-list/language-list.component';

const routes: Routes = [
  { path: '', component: CountryListComponent },
  { path: 'languages/:countryCode', component: LanguageListComponent },
  { path: '', component: CountryListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


