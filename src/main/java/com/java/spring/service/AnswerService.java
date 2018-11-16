package com.java.spring.service;

import java.util.List;

import com.entity.Answer;

public interface AnswerService {
	public void addAnswer(Answer answer);
    public List<Answer> getAnswers();
    public Answer findById(int id);
    public Answer update(Answer answer, int id);
    public void deleteAnswerById(int id);
    public Answer updatePartially(Answer answer, int id);
}
