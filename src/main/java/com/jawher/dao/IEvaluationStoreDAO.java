package com.jawher.dao;

import java.util.List;

import com.jawher.entity.Evaluation;

public interface IEvaluationStoreDAO {
	
	List<Evaluation> getEvaluations();
	Evaluation getEvaluation(int EvaluationId);
	Evaluation createEvaluation(Evaluation Evaluation);
	Evaluation updateEvaluation(int EvaluationId,Evaluation Evaluation);
	boolean deleteEvaluation(int EvaluationId);

}
