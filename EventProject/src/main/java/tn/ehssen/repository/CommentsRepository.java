package tn.ehssen.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.ehssen.entity.CategorieEvents;
import tn.ehssen.entity.Comments;




@Repository
public interface CommentsRepository extends CrudRepository<Comments,Long>{
	
	// Collection<Comments> findByEvent_Id(Long idEvent);
	
	//@Query("Select c FROM Comments c join c.EventCo bs where bs.categorieEvents = :categorieEvents")
	//List<Comments> CommentsCategory(@Param("categorieEvents") CategorieEvents categorieEvents);
	
	//@Modifying
  //  @Transactional
  //  @Query("UPDATE Comments e JOIN e.PostCo bs SET e.descriptionCommentPost = :descriptionCommentPost WHERE bs.title = :title")
  // void mettreAjourCommentsBytitleOfPost(@Param("descriptionCommentPost")String descriptionCommentPost, @Param("title")String title);


	

















}

