import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-country-data',
  templateUrl: './country-data.component.html',
  styleUrls: ['./country-data.component.less']
})

export class CountryDataComponent implements OnInit {
  countriesData: any[] = [];
  regions: string[] = [];
  selectedRegion: string = '';
  fromDate: string = '';
  toDate: string = '';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.loadCountriesData();
    this.loadRegions();
  }

  loadCountriesData(): void {
    // this.http.get<any[]>('/api/countries/data').subscribe(data => {
    //   this.countriesData = data;
    // });
  }

  loadRegions(): void {
    // this.http.get<string[]>('/api/regions').subscribe(data => {
    //   this.regions = data;
    // });
  }

  applyFilters(): void {
    // data based on selectedRegion, fromDate, and toDate
  }
}
