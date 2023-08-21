import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LanguageService {

  constructor(private http: HttpClient) { }

  getLanguagesByCountry(countryCode: string) {
    return this.http.get<any[]>(`/api/languages/${countryCode}`);
  }
}
