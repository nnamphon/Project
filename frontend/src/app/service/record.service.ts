import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class RecordService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getMold() : Observable<any> {
    return this.http.get(this.API + '/mold');
  }
  getPayment() : Observable<any> {
    return this.http.get(this.API + '/payment');
  }
  getCoffeeorder(): Observable<any> {
    return this.http.get(this.API + '/coffeeorder');
  }
  getStaff(): Observable<any> {
    return this.http.get(this.API + '/staff');
  }
  getCustomer(): Observable<any> {
    return this.http.get(this.API + '/customer');
  }

  getResponsible(): Observable<any> {
    return this.http.get(this.API + '/responsible');
  }
}
