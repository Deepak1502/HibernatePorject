package com.java.spring.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entity.Answer;
import com.java.spring.dao.AnswerDao;

@ComponentScan(basePackages = "com.java.spring.configuration")
@ComponentScan(basePackages = "com.java.spring.dao")
@Repository
public class AnswerDaoImpl implements AnswerDao {

	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void addAnswer(Answer answer) {
		Session session = sessionFactory.getCurrentSession();
        session.save(answer);
		
	}

	@Override
	public List<Answer> getAnswers() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Answer> answer=session.createCriteria(Answer.class).list();
		return answer;
	}

	@Override
	public Answer findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Answer answer=session.get(Answer.class,id);
		return answer;
	}

	@Override
	public Answer updateAnswer(Answer answer, int id) {
		Session session = sessionFactory.getCurrentSession();
		Answer answer1=session.get(Answer.class, id);
		answer1.setPostedBy(answer.getPostedBy());
		answer1.setAnswername(answer.getAnswername());
		return answer1;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Answer answer=session.get(Answer.class, id);
		session.delete(answer);
		
	}

}
