package com.java.spring.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entity.Question;
import com.java.spring.dao.QuestionDao;

@ComponentScan(basePackages = "com.java.spring.configuration")
@ComponentScan(basePackages = "com.java.spring.dao")
@Repository
public class QuestionDaoImpl implements QuestionDao{

	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public void addQuestion(Question question) {
		Session session = sessionFactory.getCurrentSession();
        session.save(question);
		
	}
	@Override
	public List<Question> getQuestions() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Question> question=session.createCriteria(Question.class).list();
		return question;
	}
	@Override
	public Question findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Question question=session.get(Question.class,id);
		return question;
	}
	@Override
	public Question update(Question question, int id) {
		Session session = sessionFactory.getCurrentSession();
		Question question1=session.get(Question.class, id);
		question1.setqName(question.getqName());
		question1.setAnswers(question.getAnswers());
		return question1;
	}
	@Override
	public Question updateQuestion(Question question, int id) {
		Session session = sessionFactory.getCurrentSession();
		Question question1=(Question)session.get(Question.class, id);
		question1.setqName(question.getqName());
		return question1;
	}
	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Question question=session.get(Question.class, id);
		session.delete(question);
	}
	
	
}
