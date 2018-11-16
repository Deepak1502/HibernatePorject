package com.java.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Question;
import com.entity.User;
import com.java.spring.dao.QuestionDao;
import com.java.spring.dao.UserDao;
import com.java.spring.service.QuestionService;

@ComponentScan(basePackages = "com.java.spring.dao")
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
    QuestionDao questionDao;

	@Override
	public void createQuestion(Question question) {
		questionDao.addQuestion(question);
		
	}

	@Override
	public List<Question> getQuestion() {
		
		return questionDao.getQuestions();
	}

	@Override
	public Question findById(int id) {
		// TODO Auto-generated method stub
		return questionDao.findById(id);
	}

	@Override
	public Question update(Question question, int id) {
		// TODO Auto-generated method stub
		return questionDao.updateQuestion(question, id);
	}

	@Override
	public void deleteQuestionById(int id) {
		questionDao.delete(id);
		
	}

	@Override
	public Question updatePartially(Question question, int id) {
		// TODO Auto-generated method stub
		return questionDao.update(question, id);
	}
	
}
