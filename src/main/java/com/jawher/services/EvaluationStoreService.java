package com.jawher.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawher.dao.IEvaluationStoreDAO;
import com.jawher.entity.Evaluation;
 

@Service
public class EvaluationStoreService implements IEvaluationStoreService {
	
	@Autowired
	private IEvaluationStoreDAO dao;

	@Override
	public List<Evaluation> getEvaluations() {
		return dao.getEvaluations();
	}


	@Override
	public Evaluation createEvaluation(Evaluation Evaluation) {
		return dao.createEvaluation(Evaluation);
	}

	@Override
	public Evaluation updateEvaluation(int EvaluationId, Evaluation Evaluation) {
		return dao.updateEvaluation(EvaluationId, Evaluation);
	}

	@Override
	public Evaluation getEvaluation(int EvaluationId) {
		return dao.getEvaluation(EvaluationId);
	}

	@Override
	public boolean deleteEvaluation(int EvaluationId) {
		return dao.deleteEvaluation(EvaluationId);
	}

}
