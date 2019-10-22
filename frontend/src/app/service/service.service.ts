import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  public API = '//localhost:8080';
  

  public counter = 0;
  public push = false;
  public numberMember = 0;

  public mold = {
    moldID : '',
    nameM : String,
    model : '',
    partNo : '',
    address : '',
    partName : '',
    
  };
  public responsible = {
    resID : '',
    nameS : String,
    other : ''
  };
  public point = {
    id : '',
    nameM : String,
    model : '',
    partNo : '',
    address : '',
    partName : '',
    

  };

  public serviceType: any;

  getMold(): Observable<any> {
    return this.http.get(this.API + '/mold');
  }

  getPoint():Observable<any> {
    return this.http.get(this.API + '/point');
  }
  getResponsible(): Observable<any> {
    return this.http.get(this.API + '/responsible');
  }



  constructor(public  http: HttpClient ) { }
}
