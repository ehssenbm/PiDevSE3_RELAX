import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { events } from 'src/app/models/events-model';
import { eventService } from 'src/app/services/event.service';
@Component({
  selector: 'app-events-details-page',
  templateUrl: './events-details-page.component.html',
  styleUrls: ['./events-details-page.component.scss']
})
export class EventsDetailsPageComponent implements OnInit {
  @ViewChild('rate', { static: false }) rate: ElementRef;
  change(event: any): void {
      let rate = this.rate.nativeElement;
      rate.innerHTML = '<span> ' + event.value + '</span>';
  }
  events : any;
  event!: events;
  form : boolean = false;
  closeResult!: string;
  constructor(private service:eventService) { }

  ngOnInit(): void{ 

    this.retrieveAllevents();

    this.events = {
      idEvent : null,
    nameEvent : null,
    nbPlace : null,
    EventDescription : null,
    dateEvent : null,
	  Adress : null,
  	photos : null,
    CategorieEvents:null,
    pseudo:null,
    }

  
  }
  retrieveAllevents(){
  this.service.retrieveAllevents().subscribe(res => this.events=res);
}

addevent(p: any){
  this.service.addevent(p).subscribe(() => {
    this.retrieveAllevents();
    this.form = false;
  });
}

editevent(event : Event){
  this.service.editevent(event).subscribe();
}
deleteevent(idEvent : any){
  this.service.deleteevent(idEvent).subscribe(() => this.retrieveAllevents())
}

}
