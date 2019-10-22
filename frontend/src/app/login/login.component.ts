import {Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  staff: any = {
    username: '',
    password: ''
  }

  check: any = ''
  constructor(private httpClient: HttpClient,
              private router: Router) { }

  ngOnInit() {
  }

  login() {
    if (this.staff.username === '' || this.staff.password === '') {
      alert('Please complete all information.');
    } else {
      this.httpClient.get('http://localhost:8080/staff/' + this.staff.username + '/' + this.staff.password, this.staff)
        .subscribe(
          data =>   {
            this.check = data;
            console.log('PUT Request is successful', data);
            if (this.check === true) {
              alert('login sucessful');
              this.router.navigate(['home/admin', {
              }]);
            } else {
              alert('Cannot login. Please check your user name and password');
            }
          },
          error =>  {
            console.log('Error', error);
          }
        );
    }


  }
}
