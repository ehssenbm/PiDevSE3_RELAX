package com.jawher.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawher.dao.IQuizStoreDAO;
import com.jawher.entity.Quiz;
 

@Service
public class QuizStoreService implements IQuizStoreService {
	
	@Autowired
	private IQuizStoreDAO dao;

	@Override
	public List<Quiz> getQuizs() {
		return dao.getQuizs();
	}


	@Override
	public Quiz createQuiz(Quiz Quiz) {
		return dao.createQuiz(Quiz);
	}

	@Override
	public Quiz updateQuiz(int QuizId, Quiz Quiz) {
		return dao.updateQuiz(QuizId, Quiz);
	}

	@Override
	public Quiz getQuiz(int QuizId) {
		return dao.getQuiz(QuizId);
	}

	@Override
	public boolean deleteQuiz(int QuizId) {
		return dao.deleteQuiz(QuizId);
	}

}
