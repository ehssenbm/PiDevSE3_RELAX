package tn.ehssen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.ehssen.entity.Event;
import tn.ehssen.repository.EventRepository;
@Slf4j
@Service

public class EventServiceImpl  implements EventService{

	@Autowired
	EventRepository EventRepository;

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


}
