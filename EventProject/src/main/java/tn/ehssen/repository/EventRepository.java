package tn.ehssen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.ehssen.entity.Event;


@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
