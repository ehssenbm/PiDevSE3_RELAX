package tn.ehssen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.ehssen.entity.Event;
import tn.ehssen.service.EventServiceImpl;

@RestController
public class EventController {
	@Autowired
	EventServiceImpl EventService;
	@PostMapping("/addEvent")
	@ResponseBody
	void addEvent(@RequestBody Event c ) {
	EventService.addEvent(c);
	}

	@DeleteMapping("/remove-event/{id_charity}")
	@ResponseBody
	public void removeEvent(@PathVariable("idEvent") Long idEvent) {
	EventService.removeEvent(idEvent);
	}
	@PutMapping("/update-event")
	@ResponseBody
	public void updateEvent(@RequestBody Event c) {
	EventService.updateEvent(c);
	}
	// http://localhost:8085/SpringMVC/client/retrieve-all-clients

	@GetMapping("/retrieve-all-events")
	@ResponseBody
	public List<Event> getEvents() {
	List<Event> listCharityEvents = EventService.retrieveAllEvents();
	return listCharityEvents;

	}

}
