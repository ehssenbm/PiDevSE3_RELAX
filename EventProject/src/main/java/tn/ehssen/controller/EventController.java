package tn.ehssen.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.ehssen.entity.Admin;
import tn.ehssen.entity.CategorieEvents;
import tn.ehssen.entity.Comments;
import tn.ehssen.entity.Event;
import tn.ehssen.entity.EventOpenData;
import tn.ehssen.entity.UploadImagePublication;
import tn.ehssen.service.EventServiceImpl;







@RestController
public class EventController {
	@Autowired
	EventServiceImpl EventService;
	
	
	
	
	
	
	
	//@ApiOperation(value = "Récuperer la liste des Admins ")
		@GetMapping("/retrieve-all-Admins")
		@ResponseBody
		public List<Admin> getAdmins()  {
		List<Admin> listAdmins = EventService.retrieveAllAdmins();
		return listAdmins;
		}
		
		//@ApiOperation(value = "Récuperer le Admin de l'id mentionné  ")
		@GetMapping("/retrieve-Admin/{idAdmin}")
		@ResponseBody
		public Admin retrieveAdmin(@PathVariable("idAdmin") Long idAdmin) {
		return EventService.retrieveAdmin(idAdmin);
		}

		
		//@ApiOperation(value = "Ajouter un Admin  ")
		@PostMapping("/add-Admin")
		@ResponseBody
		public Admin addAdmin(@RequestBody Admin Admin){
			Admin Admins = EventService.addAdmin(Admin);
		return Admins;
		}
		
		// http://localhost:8085/SpringMVC/client/remove-client/{client-id}
		@DeleteMapping("/remove-Admin/{idAdmin}")
		@ResponseBody
		public void removeAdmin(@PathVariable("idAdmin") Long idAdmin) {
			EventService.deleteAdmin(idAdmin);
		}

		// http://localhost:8085/SpringMVC/client/modify-client
		@PutMapping("/modify-Admin")
		@ResponseBody
		public Admin modifyAdmin(@RequestBody Admin Admin) {
		return EventService.updateAdmin(Admin);
		}
	///////////////////////////////////////////////////////////////////////////////////////////
	
	@PostMapping("/addEvent")
	@ResponseBody
	void addEvent(@RequestBody Event c ) {
	EventService.addEvent(c);
	}

	@DeleteMapping("/remove-event/{idEvent}")
	@ResponseBody
	public void removeEvent(@PathVariable("idEvent") Long idEvent) {
	EventService.removeEvent(idEvent);
	}
	@PutMapping("/update-event")
	@ResponseBody
	public void updateEvent(@RequestBody Event c  ) {
	EventService.updateEvent(c);
	}


	@GetMapping("/retrieve-all-events")
	@ResponseBody
	public List<Event> getEvents() {
	List<Event> listCharityEvents = EventService.retrieveAllEvents();
	return listCharityEvents;

	}
	
	@GetMapping("/Event-category/{CategorieEvents}")
	public List<Event> retrieveEventparCategorie(@PathVariable("CategorieEvents") CategorieEvents CategorieEvents) {
		return EventService.retrieveEventparCategorie(CategorieEvents);
	}
	
	@GetMapping("/Event-date/{dateEvent}")
	public List<Event> retrieveEventpardateEvent(@PathVariable("dateEvent")@DateTimeFormat(pattern="yyyy-MM-dd") Date dateEvent) {
		return EventService.retrieveEventpardateEvent(dateEvent);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	

    //creer un event
    @PostMapping("/addEventPrive")
    public Long creerEventPrivee(@RequestBody Event Event){
      long idEvent =  EventService.creerEventPrivee(Event);

        return idEvent;

    }

    //sauvegarder les evenement opendata dans notre base
    @PostMapping("/event/openData")
    public long openDataEventSave(@RequestBody EventOpenData eventOpenData){
        long idEventO =  EventService.creerEventOpenData(eventOpenData);

        return idEventO;

    }

    //recuperer tous les evenet openData
    @GetMapping( "/event")
    public Iterable<EventOpenData> getAllEventOpenData(){

        return EventService.getAllEventOpenData();

    }

    //recuperer  tous les events
    @GetMapping( "/event/{pseudo}")
    public Collection<Event> getEventByPseudo(@PathVariable("pseudo") String pseudo){
      return   EventService.getEventPrviateByPseudo(pseudo);

    }

    //recuperer  tous les events
    @GetMapping("/event/private/{idEvent}")
    public Event getEventByIdEvent(@PathVariable("idEvent") long idEvent){
        return   EventService.getEventPrviateByIdEvent(idEvent);

    }

    //recuperer  tous les opendata events
    @GetMapping( "/event/openData/{idEventO}")
    public EventOpenData getEventOpenDataByIdEventO(@PathVariable("idEventO") long idEventO){
        return   EventService.getEventOpenDataByIdEventO(idEventO);

    }

	//////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	//@ApiOperation(value = "Récuperer la liste des Comments ")
		@GetMapping("/retrieve-all-Comments")
		@ResponseBody
		public List<Comments> getCommentss()  {
		List<Comments> listCommentss = EventService.retrieveAllCommentss();
		return listCommentss;
		}
		
		//@ApiOperation(value = "Récuperer le Comments de l'id mentionné  ")
		@GetMapping("/retrieve-Comments/{idCommentEvent}")
		@ResponseBody
		public Comments retrieveComments(@PathVariable("idCommentEvent") Long idCommentEvent) {
		return EventService.retrieveComments(idCommentEvent);
		}
		
		// http://localhost:8085/SpringMVC/client/add-client
		//@ApiOperation(value = "Ajouter un Comments  ")
		@PostMapping("/add-Comments")
		@ResponseBody
		public Comments addComments(@RequestBody Comments Comments)
		{
			Comments Commentss = EventService.addComments(Comments);
		return Commentss;
		}
		
		// http://localhost:8085/SpringMVC/client/remove-client/{client-id}
		@DeleteMapping("/remove-Comments/{idCommentEvent}")
		@ResponseBody
		public void removeComments(@PathVariable("idCommentEvent") Long idCommentEvent) {
			EventService.deleteComments(idCommentEvent);
		}
		
		// http://localhost:8085/SpringMVC/client/modify-client
		@PutMapping("/modify-Comments")
		@ResponseBody
		public Comments modifyComments(@RequestBody Comments Comments) {
		return EventService.updateComments(Comments);
		}

		
		////////////////////////////////////////////////////////////////////////////////
		@PostMapping("/file")
	    @ResponseBody
	    @Transactional
	    public Object  uploadImg (@RequestParam("file") @Nullable MultipartFile file, @RequestParam("idEvent") Long idEvent) {
	        Event pub =EventService.retrieveEvent(idEvent);
	        if(pub==null)
	        {
	            Map<String, String> errorDetails= new HashMap<>();
	            errorDetails.put("message", "publication non definit");
	            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	        }
	        if(file!=null) {
	            UploadImagePublication image =pub.getImage();

	            if(image==null)
	            {
	                image= new UploadImagePublication();
	                image.setEvent(pub);
	                pub.setImage(image);
	            }

	            try {
	                image.setData(file.getBytes());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            image.setName(file.getOriginalFilename());

	            EventService.saveImage(image);

	            EventService.updateEvent(pub);
	        }


	        return pub;
	    }
		////////////////////////////////////////////////////////////////////////////
		@PutMapping(value = "/affecterUserEvent/{idUser}/{idEvent}") 
		@ResponseBody
		public void affecterUserEvent(@PathVariable("idUser") Long idUser, @PathVariable("idEvent") Long idEvent) {
			EventService.affecterUserEvent(idUser, idEvent);	
		}
		
		@PostMapping("addetaffecteEvent/{idUser}")
		@ResponseBody
		public void ajouterEtAffecterEventParUser(@RequestBody Event Event, @PathVariable("idUser") Long idUser){
			EventService.ajouterEtAffecterEventParUser(Event, idUser);
		}
		
		
		@PostMapping("/Admin/addComment/{idAdmin}/{idEvent}")
		@ResponseBody
		public void addCommentAndAssignAdminAndEvent(@RequestBody Comments comment, @PathVariable("idAdmin") Long idAdmin, @PathVariable("idEvent") Long idEvent) {
			EventService.addCommentsAndAssignEventAndAdmin(comment, idAdmin, idEvent);
			
		}
		
		
		
	

}
