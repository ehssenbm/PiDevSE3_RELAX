package com.jawher.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jawher.entity.Employer;

@Transactional
@Repository
public class EmployerStoreDAO implements IEmployerStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Employers available in database and return it as List<Employer>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employer> getEmployers() {
		
		String hql = "FROM Employer as atcl ORDER BY atcl.id";
		return (List<Employer>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Employer detail by given Employer id 
	 */
	@Override
	public Employer getEmployer(int EmployerId) {
		
		return entityManager.find(Employer.class, EmployerId);
	}

	/**
	 * This method is responsible to create new Employer in database
	 */
	@Override
	public Employer createEmployer(Employer Employer) {
		entityManager.persist(Employer);
		Employer b = getLastInsertedEmployer();
		return b;
	}

	/**
	 * This method is responsible to update Employer detail in database
	 */
	@Override
	public Employer updateEmployer(int EmployerId, Employer Employer) {
		
		//First We are taking Employer detail from database by given Employer id and 
		// then updating detail with provided Employer object
		Employer EmployerFromDB = getEmployer(EmployerId);
		EmployerFromDB.setNom(Employer.getNom());
		EmployerFromDB.setPrenom(Employer.getPrenom());
		EmployerFromDB.setUsername(Employer.getUsername());
		EmployerFromDB.setPassword(Employer.getPassword());
		EmployerFromDB.setEmail(Employer.getEmail());
		EmployerFromDB.setNiveau(Employer.getNiveau());
		EmployerFromDB.setTelephone(Employer.getTelephone());
		EmployerFromDB.setPhoto(Employer.getPhoto());
		entityManager.flush();
		
		//again i am taking updated result of Employer and returning the Employer object
		Employer updatedEmployer = getEmployer(EmployerId);
		
		return updatedEmployer;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteEmployer(int EmployerId) {
		Employer Employer = getEmployer(EmployerId);
		entityManager.remove(Employer);
		
		//we are checking here that whether entityManager contains earlier deleted Employer or not
		// if contains then Employer is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Employer);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Employer class
	 * @return Employer
	 */
	private Employer getLastInsertedEmployer(){
		String hql = "from Employer order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Employer Employer = (Employer)query.getSingleResult();
		return Employer;
	}

}
