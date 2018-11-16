package com.java.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Answer;
import com.java.spring.dao.AnswerDao;
import com.java.spring.service.AnswerService;

@ComponentScan(basePackages = "com.java.spring.dao")
@ComponentScan(basePackages = "com.java.spring.DaoImpl")
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService{

	@Autowired
    AnswerDao answerDao;
	
	@Override
	public void addAnswer(Answer answer) {
		answerDao.addAnswer(answer);
		
	}

	@Override
	public List<Answer> getAnswers() {
		
		return answerDao.getAnswers();
	}

	@Override
	public Answer findById(int id) {
		
		return answerDao.findById(id);
	}

	@Override
	public Answer update(Answer answer, int id) {
		// TODO Auto-generated method stub
		return answerDao.updateAnswer(answer, id);
	}

	@Override
	public void deleteAnswerById(int id) {
		answerDao.delete(id);
		
	}

	@Override
	public Answer updatePartially(Answer answer, int id) {
		// TODO Auto-generated method stub
		return answerDao.updateAnswer(answer, id);
	}

}
