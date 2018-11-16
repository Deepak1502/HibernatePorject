package com.java.spring.DaoImpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.entity.User;
import com.java.spring.dao.UserDao;
@ComponentScan(basePackages = "com.java.spring.configuration")
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public List<User> getUser() {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<User> list= session.createCriteria(User.class).list();
        return list;
    }

    public User findById(int id) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        User user=(User) session.get(User.class,id);
        return user;
    }

    public User update(User val, int id) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        User user =(User)session.get(User.class, id);
        user.setCountry(val.getCountry());
        user.setName(val.getName());
        session.update(user);
        return user;
    }

    public void delete(int id) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        User user = findById(id);
        session.delete(user);
    }
    @Override
    public User updateCountry(User val, int id){
        Session session = sessionFactory.getCurrentSession();
        User user = (User)session.load(User.class, id);
        user.setCountry(val.getCountry());
        return user;
    }

}