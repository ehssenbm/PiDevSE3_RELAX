package tn.ehssen.service;
import java.util.List;

import tn.ehssen.entity.Event;

public interface EventService {
	void addEvent(Event c);
	void removeEvent(Long idEvent);
	void updateEvent(Event c);
	List<Event> retrieveAllEvents();
	


}
