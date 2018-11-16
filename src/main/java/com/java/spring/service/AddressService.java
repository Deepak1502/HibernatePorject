package com.java.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.UserAddress;
@Service
public interface AddressService {
	public void createAddress(UserAddress userAddress);
    public List<UserAddress> getUserAddress();
    public UserAddress findById(int id);
    public UserAddress updateAddress(UserAddress userAddress, int id);
    public void deleteUserAddressById(int id);
}
