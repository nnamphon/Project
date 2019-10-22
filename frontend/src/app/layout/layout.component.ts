import { Component, OnInit , ViewChild, ElementRef, NgZone } from '@angular/core';
import { SearchAllService } from '../service/server-all.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})

export class LayoutComponent implements OnInit {
  [x: string]: any;
  points :Array<any>;
  
  public i = 0;
  constructor(public  httpClient: HttpClient ,  public  controller:SearchAllService,) { }

  ngOnInit() {
    
    this.controller.getPoint().subscribe(data =>{
      this.points = data;
      console.log(this.points);
    });
    
  }

}
