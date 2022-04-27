
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError , map, tap } from 'rxjs/operators';
import { categorieEvents } from '../enum/categorieEvents.enum';
import { events } from '../models/events-model';


@Injectable({ providedIn: 'root' })

export class eventService {

  private categoryUrl = 'http://localhost:8080/Event-category';

  readonly rootURL = 'http://localhost:8080';
  list : events[];
  readonly API_URL = 'http://localhost:8080';
  formData: any;
  http: any;
  constructor(private httpClient: HttpClient) { }

  retrieveAllevents() {
    console.log('eventservice')
    return this.httpClient.get(`http://localhost:8080/retrieve-all-events`)
    
    }
  
getCategorieEvents(): Observable<categorieEvents[]> {

  return this.httpClient.get(this.categoryUrl).pipe(
    tap (console.log),
      catchError(this.handleError)
  );
}
getEventsListPaginate(thePage: number, 
  thePageSize: number, 
  theEventCategory: number): Observable<GetResponseEvents> {


const searchUrl = `${this.API_URL}/Event-category=${theEventCategory}`
+ `&page=${thePage}&size=${thePageSize}`;

return this.httpClient.get<GetResponseEvents>(searchUrl);
}
 
  addevent(event : any) {
    return this.httpClient.post(`${this.API_URL}/addEvent`, event)
  }
  editevent(event : any){
    return this.httpClient.put(`${this.API_URL}/update-event`, event)
  }
  deleteevent(idEvent : any){
    return  this.httpClient.delete(`${this.API_URL}/remove-event/${idEvent}`)
  }
  // refreshList(){
  //   this.http.get(`http://localhost:8080/retrieve-all-events`)
  //   .toPromise()
  //   .then(res => this.list = res as events[]);
  // }
  private handleError(error: HttpErrorResponse): Observable <never> {
    console.log(error);

    return throwError(`Method not implemented - error code :${error.status}`);
  }
}
interface GetResponseEvents {
  _embedded: {
    events: events[];
  },
  page: {
    size: number,
    totalElements: number,
    totalPages: number,
    number: number
  }
}