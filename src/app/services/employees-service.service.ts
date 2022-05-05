import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { employee } from '../model/employee';
import { TokenStorageService } from '../token-storage.service';
const httpOption ={
  headers:new HttpHeaders({'Content-Type':'application/json'})
}
@Injectable({
  providedIn: 'root'
})
export class EmployeesServiceService {
getAllEmployeUrl:string="http://localhost:8089/SpringMVC/employee/showAll";
 


  constructor(private http:HttpClient,private tokenStorage:TokenStorageService) { }

  getEmployes(token:string):Observable<employee[]>{
    let tokenStr='Bearer '+token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    
    return this.http.get<employee[]>(this.getAllEmployeUrl,{headers, responseType: 'text' as 'json' });
      }

}
