package com.java.spring.dao;

import java.util.List;

import com.entity.UserAddress;

public interface AddressDao {
	public void addAddress(UserAddress userAddress);
    public List<UserAddress> getUserAddress();
    public UserAddress findById(int id);
    public UserAddress updateAddress(UserAddress userAddress, int id);
    public void delete(int id);
}
