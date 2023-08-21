import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
export const API_URL = 'http://localhost:8080'; // Replace with your API URL

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.css']
})
export class MyComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchData();
  }

  fetchData() {
    this.http.get(`${API_URL}/your-api-endpoint`).subscribe(data => {
      console.log(data);
    });
  }

}
