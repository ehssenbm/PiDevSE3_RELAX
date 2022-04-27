import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-contact-page',
    templateUrl: './claim-page.component.html',
    styleUrls: ['./claim-page.component.scss']
})
export class ClaimPageComponent implements OnInit {

    constructor() { }

    ngOnInit(): void {
    }

    submit(form){
        var name = form.name;
        console.log(name);

        var email = form.email;
        console.log(email);

        var number = form.number;
        console.log(number);

        var subject = form.subject;
        console.log(subject);

        var message = form.message;
        console.log(message);
    }

}
