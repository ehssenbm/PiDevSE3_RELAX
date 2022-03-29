package tn.ehssen.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.ehssen.entity.CategorieEvents;
import tn.ehssen.entity.Event;



@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
	Collection<Event> getEventByPseudo(String pseudo);
    Event getEventByIdEvent(long idEvent);
	
	
	@Query("Select COUNT(*) FROM Event c where c.CategorieEvents = :CategorieEvents")
	int nbreCategorieByEvent(@Param("CategorieEvents") CategorieEvents CategorieEvents);
	
	@Query("Select c FROM Event c where CategorieEvents = :CategorieEvents")
	List<Event> retrieveEventsparCategorie(@Param("CategorieEvents") CategorieEvents CategorieEvents);
	
	@Query("Select c FROM Event c where dateEvent = :dateEvent")
	List<Event> retrieveEventparDateEvent(@Param("dateEvent") Date dateEvent);
	
	
	
	
	
}
