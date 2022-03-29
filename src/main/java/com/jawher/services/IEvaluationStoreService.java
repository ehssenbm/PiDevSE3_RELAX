package com.jawher.services;

import java.util.List;

import com.jawher.entity.Evaluation;

public interface IEvaluationStoreService {
	
	List<Evaluation> getEvaluations();
	Evaluation createEvaluation(Evaluation Evaluation);
	Evaluation updateEvaluation(int EvaluationId, Evaluation Evaluation);
	Evaluation getEvaluation(int EvaluationId);
	boolean deleteEvaluation(int EvaluationId);

}
