package com.java.spring.dao;

import java.util.List;

import com.entity.Question;

public interface QuestionDao {
	public void addQuestion(Question question);
    public List<Question> getQuestions();
    public Question findById(int id);
    public Question update(Question question, int id);
    public Question updateQuestion(Question question, int id);
    public void delete(int id);
}
