package tn.ehssen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.ehssen.entity.User;





@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	
}