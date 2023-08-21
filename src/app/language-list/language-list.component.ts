import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LanguageService } from '../language.service';

@Component({
  selector: 'app-language-list',
  templateUrl: './language-list.component.html',
  styleUrls: ['./language-list.component.css']
})
export class LanguageListComponent implements OnInit {

  countryCode: string = ''; // Initialize the property in the constructor, but there is an error here :(

  languages: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private languageService: LanguageService
  ) {
    this.countryCode = ''; // here the same issue 
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.countryCode = params['countryCode'];
      this.languageService.getLanguagesByCountry(this.countryCode).subscribe(data => {
        this.languages = data;
      });
    });
  }
}
