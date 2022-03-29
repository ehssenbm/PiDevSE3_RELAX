package com.jawher.services;

import java.util.List;

import com.jawher.entity.Question;

public interface IQuestionStoreService {
	
	List<Question> getQuestions();
	Question createQuestion(Question Question);
	Question updateQuestion(int QuestionId, Question Question);
	Question getQuestion(int QuestionId);
	boolean deleteQuestion(int QuestionId);

}
