package tn.ehssen.service;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import tn.ehssen.entity.Event;
import tn.ehssen.entity.EventOpenData;
import tn.ehssen.entity.UploadImagePublication;
import tn.ehssen.exeptions.EventNotFoundException;
import tn.ehssen.entity.Admin;
import tn.ehssen.entity.CategorieEvents;
import tn.ehssen.entity.Comments;

public interface EventService {
	
	List<Admin> retrieveAllAdmins();

	Admin addAdmin(Admin a);

	void deleteAdmin(Long idAdmin);

	Admin updateAdmin(Admin a);

	Admin retrieveAdmin(Long idAdmin);
	///////////////////////////////////////////////////////////////////////////////////
	
	void addEvent(Event c);
	
	void removeEvent(Long idEvent);
	
	void updateEvent(Event c );
	
	List<Event> retrieveAllEvents();
	
	List<Event> retrieveEventparCategorie(CategorieEvents CategorieEvents);
	
	public List<Event> retrieveEventpardateEvent(Date dateEvent);
	
	
    
	long creerEventPrivee(Event event);
	long creerEventOpenData(EventOpenData eventOpenData);
	Iterable<EventOpenData> getAllEventOpenData();
	Collection<Event> getEventPrviateByPseudo(String pseudo);
	Event getEventPrviateByIdEvent(long idEvent) throws EventNotFoundException;
	EventOpenData getEventOpenDataByIdEventO(long idEventO) throws EventNotFoundException;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	List<Comments> retrieveAllCommentss();

	Comments addComments(Comments Comments);

	void deleteComments(Long idCommentEvent);

	Comments updateComments(Comments Comments);

	Comments retrieveComments(Long idCommentEvent);
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public UploadImagePublication saveImage(UploadImagePublication p);
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	void nbrecategorieParEvent();
	
	
	Event retrieveEvent(Long idEvent);
	
	public void affecterUserEvent(Long idUser, Long idEvent);
	
	void ajouterEtAffecterEventParUser(Event Event, Long idUser);
	
	public void addCommentsAndAssignEventAndAdmin(Comments comments , Long idAdmin ,Long idEvent );
	
	

	
	
	
	
	
}
