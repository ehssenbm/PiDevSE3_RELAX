package com.jawher.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jawher.entity.Evaluation;

@Transactional
@Repository
public class EvaluationStoreDAO implements IEvaluationStoreDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all Evaluations available in database and return it as List<Evaluation>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Evaluation> getEvaluations() {
		
		String hql = "FROM Evaluation as atcl ORDER BY atcl.id";
		return (List<Evaluation>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Evaluation detail by given Evaluation id 
	 */
	@Override
	public Evaluation getEvaluation(int EvaluationId) {
		
		return entityManager.find(Evaluation.class, EvaluationId);
	}

	/**
	 * This method is responsible to create new Evaluation in database
	 */
	@Override
	public Evaluation createEvaluation(Evaluation Evaluation) {
		entityManager.persist(Evaluation);
		Evaluation b = getLastInsertedEvaluation();
		return b;
	}

	/**
	 * This method is responsible to update Evaluation detail in database
	 */
	@Override
	public Evaluation updateEvaluation(int EvaluationId, Evaluation Evaluation) {
		
		//First We are taking Evaluation detail from database by given Evaluation id and 
		// then updating detail with provided Evaluation object
		Evaluation EvaluationFromDB = getEvaluation(EvaluationId);
		EvaluationFromDB.setClassement(Evaluation.getClassement());
		EvaluationFromDB.setOpinioncollegue(Evaluation.getOpinioncollegue());
		EvaluationFromDB.setPromotion(Evaluation.getPromotion());
		EvaluationFromDB.setScore(Evaluation.getScore());
		EvaluationFromDB.setVote(Evaluation.getVote());
		
		entityManager.flush();
		
		//again i am taking updated result of Evaluation and returning the Evaluation object
		Evaluation updatedEvaluation = getEvaluation(EvaluationId);
		
		return updatedEvaluation;
	}

	/**
	 * This method is responsible for deleting a particular(which id will be passed that record) 
	 * record from the database
	 */
	@Override
	public boolean deleteEvaluation(int EvaluationId) {
		Evaluation Evaluation = getEvaluation(EvaluationId);
		entityManager.remove(Evaluation);
		
		//we are checking here that whether entityManager contains earlier deleted Evaluation or not
		// if contains then Evaluation is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Evaluation);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Evaluation class
	 * @return Evaluation
	 */
	private Evaluation getLastInsertedEvaluation(){
		String hql = "from Evaluation order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Evaluation Evaluation = (Evaluation)query.getSingleResult();
		return Evaluation;
	}

}
