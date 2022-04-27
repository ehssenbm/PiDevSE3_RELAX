import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { events } from 'src/app/models/events-model';
import { eventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-blog-page',
  templateUrl: './blog-page.component.html',
  styleUrls: ['./blog-page.component.scss']
})
export class BlogPageComponent implements OnInit {
  events : any;
  event!: events;
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

}
