import { Component, OnInit } from '@angular/core';
import {MemberService} from '../service/member.service';
import {Router} from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {ServiceService} from "../service/service.service";

@Component({
  selector: 'app-responsible',
  templateUrl: './responsible.component.html',
  styleUrls: ['./responsible.component.css']
})
export class ResponsibleComponent implements OnInit {

  addresponsible: any = {
    inputFName: '',
    inputLName: '',
    inputOther: '',
    
}
  responsible: Array<any>;
 
  number=0;

  constructor(public memberService: MemberService,
              public httpClient: HttpClient,
              public router: Router ,
              public serviceService: ServiceService) { }

  ngOnInit() {
    

}
  save() {
    if (this.addresponsible.inputFName === '' ||this.addresponsible.inputLName === '' || this.addresponsible.inputOther === '' ) {
      alert('Please complete all information.');
    } else {

      this.httpClient.post('http://localhost:8080/responsible/' , this.addresponsible)
        .subscribe(

          data => {
            console.log('PUT Request is successful', data);
          },
          error => {
            console.log('Error', error);
          }
        );

      alert('Save data successfully.');
      
    }
  }
  push(){

    this.serviceService.numberMember = this.serviceService.numberMember + this.number ;
    this.number++;
  }
}
