package com.jawher.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jawher.entity.Badge;
 

@Transactional
@Repository
public class BadgeStoreDAO implements IBadgeStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Administrateurs available in database and return it as List<Administrateur>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Badge> getAdministrateurs() {
		
		String hql = "FROM Administrateur as atcl ORDER BY atcl.id";
		return (List<Badge>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Administrateur detail by given Administrateur id 
	 */
	@Override
	public Badge getAdministrateur(int AdministrateurId) {
		
		return entityManager.find(Badge.class, AdministrateurId);
	}

	/**
	 * This method is responsible to create new Administrateur in database
	 */
	@Override
	public Badge createAdministrateur(Badge Administrateur) {
		entityManager.persist(Administrateur);
		Badge b = getLastInsertedAdministrateur();
		return b;
	}

	/**
	 * This method is responsible to update Administrateur detail in database
	 */
	@Override
	public Badge updateAdministrateur(int AdministrateurId, Badge Administrateur) {
		
		//First We are taking Administrateur detail from database by given Administrateur id and 
		// then updating detail with provided Administrateur object
		Badge AdministrateurFromDB = getAdministrateur(AdministrateurId);
		AdministrateurFromDB.setDescription(Administrateur.getDescription());
		
	 
	 
	 
		
		//again i am taking updated result of Administrateur and returning the Administrateur object
		Badge updatedAdministrateur = getAdministrateur(AdministrateurId);
		
		return updatedAdministrateur;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteAdministrateur(int AdministrateurId) {
		Badge Administrateur = getAdministrateur(AdministrateurId);
		entityManager.remove(Administrateur);
		
		//we are checking here that whether entityManager contains earlier deleted Administrateur or not
		// if contains then Administrateur is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Administrateur);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Administrateur class
	 * @return Administrateur
	 */
	private Badge getLastInsertedAdministrateur(){
		String hql = "from Administrateur order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Badge Administrateur = (Badge)query.getSingleResult();
		return Administrateur;
	}
	
	
	 

}
