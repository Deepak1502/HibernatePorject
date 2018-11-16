package com.java.spring.service;

import java.util.List;

import com.entity.Question;


public interface QuestionService {
	public void createQuestion(Question question);
    public List<Question> getQuestion();
    public Question findById(int id);
    public Question update(Question question, int id);
    public void deleteQuestionById(int id);
    public Question updatePartially(Question question, int id);
}
