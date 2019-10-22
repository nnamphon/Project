import { Component, OnInit, ViewChild } from '@angular/core';
import { SearchAllService } from '../service/server-all.service';
import {ServiceService} from '../Service/service.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { MatTableDataSource, MatSort } from '@angular/material';



@Component({
  selector: 'app-show-tables',
  templateUrl: './show-tables.component.html',
  styleUrls: ['./show-tables.component.css']
})

export class ShowTablesComponent implements OnInit {
  
 
  constructor(public  serviceService: ServiceService,private controller:SearchAllService,private httpClient:HttpClient,private router:Router) { }
  [x: string]: any;  
  public API = '//localhost:8080';
  points:Array<any>;



  dataColumns: string[] = ['table', 'dateStart','datefinish','nameS' ,'nameM', 'model','other','remove'];
  //-------------------------------Delete-----------------------------------
  DeletePoint(id) {
    if (this.serviceService.push === false) {
      this.httpClient.delete(this.API + '/point' +  '/' + id).subscribe(
        data => {
          console.log(' Delet is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
    } else {
      this.serviceService.counter = this.serviceService.counter - 1 ;
      this.httpClient.delete(this.API + '/point' +  '/' + id).subscribe(
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

  ngOnInit() {

    this.controller.getPoint().subscribe(data =>{
      this.points = data;
      console.log(this.points);
    });
    this.dataSource.sort = this.sort;
  }

}
