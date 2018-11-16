package com.java.spring.service.impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.java.spring.dao.UserDao;
import com.java.spring.service.UserService;

@ComponentScan(basePackages = "com.java.spring.dao")
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    public List<User> getUser() {
        // TODO Auto-generated method stub
        return userDao.getUser();
    }

    public User findById(int id) {
        // TODO Auto-generated method stub
        return userDao.findById(id);
    }

    public void createUser(User user) {
        // TODO Auto-generated method stub
        userDao.addUser(user);
    }

    public void deleteUserById(int id) {
        // TODO Auto-generated method stub
        userDao.delete(id);
    }
    @Override
    public User updatePartially(User user, int id) {
        userDao.updateCountry(user,id);
        return userDao.findById(id);
    }

    @Override
    public User update(User user,int id) {
        // TODO Auto-generated method stub
        return userDao.update(user, id);
    }

}