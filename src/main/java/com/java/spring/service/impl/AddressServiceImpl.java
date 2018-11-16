package com.java.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.entity.UserAddress;
import com.java.spring.dao.AddressDao;
import com.java.spring.dao.UserDao;
import com.java.spring.service.AddressService;

@ComponentScan(basePackages = "com.java.spring.dao")
@ComponentScan(basePackages = "com.java.spring.DaoImpl")
@Service
@Transactional
public class AddressServiceImpl implements AddressService{
	
	@Autowired
    AddressDao addressDao;


    public List<UserAddress> getUserAddress() {
        // TODO Auto-generated method stub
        return addressDao.getUserAddress();
    }

    public UserAddress findById(int id) {
        // TODO Auto-generated method stub
        return addressDao.findById(id);
    }

    public void createAddress(UserAddress userAddress) {
        // TODO Auto-generated method stub
    	addressDao.addAddress(userAddress);
    }

    public void deleteUserAddressById(int id) {
        // TODO Auto-generated method stub
    	addressDao.delete(id);
    }
    /*@Override
    public UserAddress updateAddressPartially(UserAddress userAddress, int id) {
    	addressDao.updateAddress(userAddress,id);
        return addressDao.findById(id);
    }*/

    @Override
    public UserAddress updateAddress(UserAddress userAddress,int id) {
        // TODO Auto-generated method stub
        return addressDao.updateAddress(userAddress, id);
    }


}
