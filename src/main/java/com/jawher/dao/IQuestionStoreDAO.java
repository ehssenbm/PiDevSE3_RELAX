package com.jawher.dao;

import java.util.List;

import com.jawher.entity.Question;

public interface IQuestionStoreDAO {
	
	List<Question> getQuestions();
	Question getQuestion(int QuestionId);
	Question createQuestion(Question Question);
	Question updateQuestion(int QuestionId,Question Question);
	boolean deleteQuestion(int QuestionId);

}
