package tn.ehssen.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.ehssen.entity.Admin;
import tn.ehssen.entity.CategorieEvents;
import tn.ehssen.entity.Comments;
import tn.ehssen.entity.Event;
import tn.ehssen.entity.EventOpenData;
import tn.ehssen.entity.UploadImagePublication;
import tn.ehssen.entity.User;
import tn.ehssen.exeptions.EventNotFoundException;
import tn.ehssen.repository.AdminRepository;
import tn.ehssen.repository.CommentsRepository;
import tn.ehssen.repository.EventOpenDataRepository;
import tn.ehssen.repository.EventRepository;
import tn.ehssen.repository.IRepositoryImagePub;







@Slf4j
@Service

public class EventServiceImpl  implements EventService{

	@Autowired
	EventRepository EventRepository;
	@Autowired
	tn.ehssen.repository.UserRepository UserRepository;
	@Autowired
	CommentsRepository commentsrepo;
	@Autowired
	IRepositoryImagePub repoimage;
	@Autowired
    EventOpenDataRepository eventOpenDataRepository;
	@Autowired
	AdminRepository adminrepo;
	

	
	
	
	
	
	@Override
	public List<Admin> retrieveAllAdmins() {
		List<Admin> admins =(List<Admin>) adminrepo.findAll();
		for (Admin admin : admins ) {
	  log.info("admin : "+ admin );
		}
		return admins ;
	
	}
	
	@Override
	public Admin retrieveAdmin(Long idAdmin) {
		Admin admin=adminrepo.findById(idAdmin).get();
		return admin;
	}
	
	@Override
	public Admin addAdmin(Admin a) {
		adminrepo.save(a);
		return a;
	}

	@Override
	public void deleteAdmin(Long idAdmin) {
		adminrepo.deleteById(idAdmin);
		
	}

	@Override
	public Admin updateAdmin(Admin a) {
		adminrepo.save(a);
		return a ;
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void addEvent(Event c) {
	EventRepository.save(c);


	}

	@Override
	public void removeEvent(Long idEvent) {
		
	EventRepository.deleteById(idEvent);

	}

	@Override
	public void updateEvent(Event c) {
		
	EventRepository.save(c);


	}

	@Override
	public List<Event> retrieveAllEvents() {
	List<Event> events =(List<Event>) EventRepository.findAll();
	for (Event event : events ) {
	 log.info("event : "+ event );

	}
	return events;
	}
	
	@Override
	public Event retrieveEvent(Long idEvent) {
		Event Event=EventRepository.findById(idEvent).get();
		return Event;
	}
	
	
	
	@Override
	public List<Event> retrieveEventparCategorie(CategorieEvents CategorieEvents) {
		return EventRepository.retrieveEventsparCategorie(CategorieEvents);
	}
	
	@Override
	public List<Event> retrieveEventpardateEvent(Date dateEvent) {
		return EventRepository.retrieveEventparDateEvent(dateEvent);
}
	
	
	
	
	
	////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
    

    @Override
    public long creerEventPrivee(Event event) {
    	EventRepository.save(event);
        return event.getIdEvent();
    }

    @Override
    public long creerEventOpenData(EventOpenData eventOpenData) {
    	eventOpenDataRepository.save(eventOpenData);
        return eventOpenData.getIdEventO();
    }

    @Override
    public Iterable <EventOpenData> getAllEventOpenData() {
        return eventOpenDataRepository.findAll();
    }

    @Override
    public Collection <Event> getEventPrviateByPseudo(String pseudo) {

        return  EventRepository.getEventByPseudo(pseudo);
    }

    @Override
    public Event getEventPrviateByIdEvent(long idEvent) throws EventNotFoundException {
    	Event event =  EventRepository.getEventByIdEvent(idEvent);
        if(event==null)
            throw new EventNotFoundException("l'evenement avec "+ idEvent+" n'existe pas");

        return event;
    }

    @Override
    public EventOpenData getEventOpenDataByIdEventO(long IdEventO) throws EventNotFoundException {
    	EventOpenData event =  eventOpenDataRepository.getEventOpenDataByIdEventO(IdEventO);
        if(event==null)
            throw new EventNotFoundException("l'evenement avec "+ IdEventO+" n'existe pas");

        return event;
    }
	///////////////////////////////////////////////////////////////////

	@Override
	public List<Comments> retrieveAllCommentss() {
		List<Comments> Comments =(List<Comments>) commentsrepo.findAll();
		for (Comments Comment : Comments ) {
	  log.info("Comments : "+ Comment );
		}
		return Comments ;
	}

	@Override
	public Comments addComments(Comments Comments) {
		commentsrepo.save(Comments);
		return Comments;
	}

	@Override
	public void deleteComments(Long idCommentEvent) {
		commentsrepo.deleteById(idCommentEvent);
		
	}

	@Override
	public Comments updateComments(Comments Comments) {
		commentsrepo.save(Comments);
		return Comments ;
	}

	@Override
	public Comments retrieveComments(Long idCommentEvent) {
		Comments Comments=commentsrepo.findById(idCommentEvent).get();
		return Comments;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	@Override
	@Scheduled(cron = "*/30 * * * * *")
	public void nbrecategorieParEvent() {
		
		log.info("--- Nombre des Events SPORT : " + EventRepository.nbreCategorieByEvent(CategorieEvents.SPORT));
		log.info("--- Nombre des Events MENTAL_HEALTH : " + EventRepository.nbreCategorieByEvent(CategorieEvents.MENTAL_HEALTH));
		log.info("--- Nombre des Events TRIP : " + EventRepository.nbreCategorieByEvent(CategorieEvents.TRIP));
	}

	@Override
	public UploadImagePublication saveImage(UploadImagePublication p) {
		return repoimage.save(p);
	}
	
	
	

	public void affecterUserEvent(Long idUser, Long idEvent) {
		Event Event = EventRepository.findById(idEvent).get();
		User User = UserRepository.findById(idUser).get();
		User.getEvents().add(Event);
		UserRepository.save(User);
		
	}
	
	
	

	@Override
	public void ajouterEtAffecterEventParUser(Event Event, Long idUser) {
		User User = UserRepository.findById(idUser).orElse(null);
		Event.setUserEvent(User);
		EventRepository.save(Event);
	}

	@Override
	public void addCommentsAndAssignEventAndAdmin(Comments comments, Long idAdmin, Long idEvent) {
		Admin m = adminrepo.findById(idAdmin).orElse(null);
		Event e = EventRepository.findById(idEvent).orElse(null);
		comments.setAdminC(m);
		comments.setEventCo(e);
		commentsrepo.save(comments);
		
	}

	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	//@Override
	//public void mettreAjourCommentsBytitleOfPost(String descriptionCommentPost, String title) {
	//	commentsrepo.mettreAjourCommentsBytitleOfPost(descriptionCommentPost, title);

	//}
	
	


}
