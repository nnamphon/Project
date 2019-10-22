import { Component, OnInit } from '@angular/core';
import {MemberService} from '../service/member.service';
import {Router} from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {ServiceService} from "../service/service.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  addmold: any = {
    inputName: '',
    inputPartNo: '',
    
}
  mold: Array<any>;
  proName: Array <any>;
  models: Array <any>;
  namepas: Array <any>;

  productSelect: number = 0;
  modelSelect:number = 0;
  partNameSelect: number = 0;
  number=0;

  constructor(public memberService: MemberService,
              public httpClient: HttpClient,
              public router: Router ,
              public serviceService: ServiceService) { }

  ngOnInit() {
    this.memberService.getProduct().subscribe(data => {
      this.proName = data;
      console.log(this.proName);
    });
    this.memberService.getModel().subscribe(data => {
      this.models = data;
      console.log(this.models);
    });
    this.memberService.getPartName().subscribe(data => {
      this.namepas = data;
      console.log(this.namepas);
    });

}
  save() {
    if (this.productSelect === 0 || this.addmold.inputName === '' || this.modelSelect === 0  ||
      this.addmold.inputPartNo === '' || this.partNameSelect === 0 ) {
      alert('Please complete all information.');
    } else {
      this.httpClient.post('http://localhost:8080/mold/' + this.productSelect + '/' +
        this.modelSelect + '/' + this.partNameSelect , this.addmold)
        .subscribe(

          data => {
            console.log('PUT Request is successful', data);
          },
          error => {
            console.log('Error', error);
          }

        );

      alert('Save data successfully.');
      this.router.navigate(['delete-mold']);
    }
  }

  push(){

    this.serviceService.numberMember = this.serviceService.numberMember + this.number ;
    this.number++;
  }
}
