import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { employee } from '../model/employee';
import { AuthentificationService } from '../services/authentification.service';
import { EmployeesServiceService } from '../services/employees-service.service';
import { TokenStorageService } from '../token-storage.service';

const TOKEN_KEY='zb';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  username:string;
  checkAuth:boolean ;
  employeeList:employee[];
  constructor(private authService:AuthentificationService,private router:Router
    ,private tokenStorag:TokenStorageService,private employeeService:EmployeesServiceService) { }

  ngOnInit(): void {
    this.username=this.tokenStorag.getUsername();
    console.log(sessionStorage.getItem(TOKEN_KEY));
    this.employeeService.getEmployes(this.authService.currentUserValue.acessToken).subscribe(
      data => {this.employeeList = data}
    );
  }
  logOutFunction(){
    this.authService.logOut();
    this.router.navigate(['/']);
  }

}
