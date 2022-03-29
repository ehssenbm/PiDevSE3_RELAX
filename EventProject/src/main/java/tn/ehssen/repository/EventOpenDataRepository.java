package tn.ehssen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.ehssen.entity.EventOpenData;

@Repository
public interface EventOpenDataRepository extends CrudRepository<EventOpenData, Long> {
    EventOpenData getEventOpenDataByIdEventO(long idEventO);
}