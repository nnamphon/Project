import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ServiceService} from '../Service/service.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-cancel-member',
  templateUrl: './cancel-member.component.html',
  styleUrls: ['./cancel-member.component.css']
})
export class CancelMemberComponent implements OnInit {
  [x: string]: any;  
    public API = '//localhost:8080';
  
  public  member = {
    moldID : Number,
    nameM : Number,
    model : String,
    password : String,
  };
  
  dataColumns: string[] = ['id', 'nameM', 'model','pass', 'CreditPay'];
//-------------------------------Delete-----------------------------------
  DeleteMold(moldID) {
    if (this.serviceService.push === false) {
      this.http.delete(this.API + '/mold' +  '/' + moldID).subscribe(
        data => {
          console.log(' Delet is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
    } else {
      this.serviceService.counter = this.serviceService.counter - 1 ;
      this.http.delete(this.API + '/mold' +  '/' + moldID).subscribe(
        data => {
          console.log(' Delet is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
    }
  }
//------------------------------------------------------------------------


  getmember(): Observable<any> {

    return this.http.get(this.API + '/mold');
  }

  constructor( public  serviceService: ServiceService, public  http: HttpClient) { }

  ngOnInit() {
    this.getmember().subscribe(data => {
      this.member = data;
      console.log(this.member);
    });
    this.serviceService.getMold().subscribe(data => {
      this.serviceService.mold = data;
      console.log(this.serviceService.mold);
    });
    
  }

}
