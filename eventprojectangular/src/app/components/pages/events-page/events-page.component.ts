import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { events } from 'src/app/models/events-model';
import { eventService } from 'src/app/services/event.service';
import { jqxRatingComponent } from 'jqwidgets-ng/jqxrating';

@Component({
  selector: 'app-events-page' ,
  templateUrl: './events-page.component.html',
  styleUrls: ['./events-page.component.scss']
})
export class EventsPageComponent implements OnInit {
  @ViewChild('rate', { static: false }) rate: ElementRef;
  modalService: any;
    change(event: any): void {
        let rate = this.rate.nativeElement;
        rate.innerHTML = '<span> ' + event.value + '</span>';
    }
  events : any;
  event: events;
  form : boolean = false;
  closeResult!: string;
  constructor(private service:eventService) { }

  ngOnInit(): void{ 
      console.log('hello')
      this.service.retrieveAllevents().subscribe(res => {this.events=res; console.log('heloo') ;console.log(res)});


    // this.retrieveAllevents();

    
  
  }
  retrieveAllevents(){
  this.service.retrieveAllevents().subscribe(res => {this.events=res; console.log('heloo') ;console.log(res)});
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
/*open(content: any) {
this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
  this.closeResult = `Closed with: ${result}`;
}, (reason) => {
  this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
});
}
private getDismissReason(reason: any): string {
  if (reason === ModalDismissReasons.ESC) {
    return 'by pressing ESC';
  } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
    return 'by clicking on a backdrop';
  } else {
    return  `with: ${reason}`;
  }
}
closeForm(){

}
cancel(){
  this.form = false;
}*/


}
