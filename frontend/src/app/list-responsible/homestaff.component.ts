import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiceService } from '../service/service.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-homestaff',
  templateUrl: './homestaff.component.html',
  styleUrls: ['./homestaff.component.css']
})
export class HomestaffComponent implements OnInit {
  [x: string]: any;  
  public API = '//localhost:8080';

public  responsible = {
  resID : Number,
  nameR : Number,
  nameL : Number,
  other : String,
  
};

dataColumns: string[] = ['id', 'nameR','nameL', 'other','remove'];
//-------------------------------Delete-----------------------------------
DeleteResponsible(resID) {
  if (this.serviceService.push === false) {
    this.http.delete(this.API + '/responsible' +  '/' + resID).subscribe(
      data => {
        console.log(' Delet is successful', data);
      },
      error => {
        console.log('Error', error);
      }
    );
  } else {
    this.serviceService.counter = this.serviceService.counter - 1 ;
    this.http.delete(this.API + '/responsible' +  '/' + resID).subscribe(
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


getresponsible(): Observable<any> {

  return this.http.get(this.API + '/responsible');
}

constructor( public  serviceService: ServiceService, public  http: HttpClient) { }

ngOnInit() {
  this.getresponsible().subscribe(data => {
    this.responsible = data;
    console.log(this.responsible);
  });
  this.serviceService.getResponsible().subscribe(data => {
    this.serviceService.responsible = data;
    console.log(this.serviceService.responsible);
  });
  
}

}
