package com.java.spring.dao;

import java.util.List;

import com.entity.Answer;

public interface AnswerDao {
	public void addAnswer(Answer answer);
    public List<Answer> getAnswers();
    public Answer findById(int id);
    public Answer updateAnswer(Answer answer, int id);
    public void delete(int id);
}
