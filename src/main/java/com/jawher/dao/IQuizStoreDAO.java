package com.jawher.dao;

import java.util.List;

import com.jawher.entity.Quiz;

public interface IQuizStoreDAO {
	
	List<Quiz> getQuizs();
	Quiz getQuiz(int QuizId);
	Quiz createQuiz(Quiz Quiz);
	Quiz updateQuiz(int QuizId,Quiz Quiz);
	boolean deleteQuiz(int QuizId);

}
