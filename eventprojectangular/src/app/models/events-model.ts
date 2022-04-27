import { categorieEvents } from "../enum/categorieEvents.enum";

export class events {
    idEvent : number;
    nameEvent : string;
    nbPlace : number;
    EventDescription : string;
    dateEvent : Date;
	Adress : string;
	photos : string;
    CategorieEvents:categorieEvents;
    pseudo:string;
    soireeId:number;
}
