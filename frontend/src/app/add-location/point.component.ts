import { Component, OnInit } from '@angular/core';
import { SearchAllService } from "../service/server-all.service";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { RecordService } from '../Service/record.service';
@Component({
  selector: 'app-point',
  templateUrl: './point.component.html',
  styleUrls: ['./point.component.css']
})
export class PointComponent implements OnInit {
  [x: string]: any;


  constructor(private controller: SearchAllService,
    private httpClient: HttpClient,
    private router: Router,
    private controller1: RecordService) { }

  //Point
  other: Array<any>;
  otherSelect: '';
  fdate: string;
  tdate: string;

  //Addpoint
  addPoints: Array<any>;
  addPointSelect: '';
  // constructor() { }


  //responsicle
  nameSs: Array<any>;
  nameSSelect: '';
  //nameCustomer
  nameCustomers: Array<any>;
  nameMSelect: '';

  users: Array<any>;
  userSelect: number = 0;

  data: any = {}

  ngOnInit() {
    this.controller.getAddpoint().subscribe(on => {
      this.addPoints = on;
      console.log(this.addPoints);
    });

    this.controller.getMold().subscribe(on => {
      this.users = on;
      console.log(this.users);
    });

    this.controller1.getResponsible().subscribe(data => {
      this.nameSs = data;
      console.log(this.nameSs);
    });
  }




  insert() {
    this.httpClient.post('http://localhost:8080/point', {
      other: this.otherSelect,
      fdate: this.fdate,
      tdate: this.tdate,
      addpoint: this.addPointSelect,
      mold: this.userSelect,
      responsible: this.nameSSelect,
    }).subscribe(value => alert("SAVE SUCCESSFULLY"));
  }

}
