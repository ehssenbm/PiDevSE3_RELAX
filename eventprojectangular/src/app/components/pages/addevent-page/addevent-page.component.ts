import { Component, Inject, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import * as events from 'events';
import { ToastrService } from 'ngx-toastr';
import { eventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-addevent-page',
  templateUrl: './addevent-page.component.html',
  styleUrls: ['./addevent-page.component.scss']
})

export class addeventPageComponent implements OnInit {
  events : any;
  event!: events;
  form : boolean = false;
  closeResult!: string;
  constructor(public service: eventService ,private toastr: ToastrService) { }

  ngOnInit() {
    this.resetForm();
  }


  resetForm(form?: NgForm) {
    if (form != null)
      form.form;
      this.service.formData = {
        idEvent : null,
      nameEvent : null,
      nbPlace : null,
      eventDescription : null,
      dateEvent : null,
      adress : null,
      photos : null,
      categorieEvents:null,
      pseudo:null,
      soireeId:null,
      }
  }

  onSubmit(form: NgForm) {
    if (this.service.formData.idEvent == 0)
      this.addevent(form);
    else
      this.editevent(form);
  }

  addevent(form: NgForm) {
    console.log(form.value)
    this.service.addevent(form.value).subscribe(
      res => {
        this.resetForm(form.value);
        this.toastr.success('Submitted successfully', 'event Register');
        // this.service.refreshList();
      },
      err => {
       
        console.log(err);
      }
    )
  }
  editevent(form: NgForm) {
    this.service.editevent(form).subscribe(
      res => {
        this.resetForm(form);
        this.toastr.info('Submitted successfully', 'event Register');
        // this.service.refreshList();
      },
      err => {
        console.log(err);
      }
    )
  }


}
