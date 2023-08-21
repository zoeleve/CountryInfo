import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountryDataComponent } from './country-data.component';

describe('CountryDataComponent', () => {
  let component: CountryDataComponent;
  let fixture: ComponentFixture<CountryDataComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CountryDataComponent]
    });
    fixture = TestBed.createComponent(CountryDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
