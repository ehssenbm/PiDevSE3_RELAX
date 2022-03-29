package tn.ehssen.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.ehssen.entity.Admin;





@Repository
public interface AdminRepository extends CrudRepository<Admin,Long>{
	
	@Modifying
    @Transactional
    @Query("UPDATE Admin e SET e.emailAdmin=:emailAdmin where e.idAdmin=:idAdmin")
    public void mettreAjourEmailByIdAdminJPQL(@Param("emailAdmin")String emailAdmin, @Param("idAdmin")Long idAdmin);
	
	
	
	
}