import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { eventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-gestion-event',
  templateUrl: './gestion-event.component.html',
  styleUrls: ['./gestion-event.component.scss']
})
export class GestionEventComponent implements OnInit {
    events: any;
    currentKeyword = '';

  constructor(private service: eventService,private router:Router) { }

  ngOnInit(): void {
      //this.chercherEvents();
      this.service.retrieveAllevents().subscribe(res => {this.events=res; console.log('gestion event') ;console.log(res)});

  }

    onChercher(value) {

    }
    retrieveAllevents(){
        this.service.retrieveAllevents().subscribe(res => {this.events=res; console.log('gestion event') ;console.log(res)});
      }

    deleteevent(e) {
            console.log(e);
            this.service.deleteevent(e.idEvent).subscribe(data => {
               // this.chercherEvents();
            }, error => {
                console.log(error);
            });
        }

        
    editevent(event : Event){
        this.service.editevent(event).subscribe();
      }

    // private chercherEvents() {
    //     this.service.retrieveEvents(this.currentKeyword)
    //         .subscribe(data => {
    //             this.events = data;
    //         }, error => {
    //             console.log(error);
    //         });
    // }
}
