package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="AddressInfo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})


public class UserAddress {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int addressId;	

@OneToOne(targetEntity=User.class)
private User user;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@Column(name="addressLine1")
private String addressLine1;


@Column(name="addressLine2")
private String addressLine2;

@Column(name="zipcode")
private String zipcode;

@Column(name="state")
private String state;

@Column(name="city")
private String city;

@Column(name="country")
private String country;


public int getAddressId() {
	return addressId;
}
public void setAddressId(int addressId) {
	this.addressId = addressId;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}



public UserAddress() {}
public UserAddress(String zipcode, String addressLine1, String addressLine2, String state, String city,
		String country) {
	super();
	this.zipcode = zipcode;
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.state = state;
	this.city = city;
	this.country = country;
}

@Override
public String toString() {
	return "UserAddress [addressId=" + addressId + ", user=" + user + ", addressLine1=" + addressLine1
			+ ", addressLine2=" + addressLine2 + ", zipcode=" + zipcode + ", state=" + state + ", city=" + city
			+ ", country=" + country + ", getUser()=" + getUser() + ", getAddressId()=" + getAddressId()
			+ ", getZipcode()=" + getZipcode() + ", getAddressLine1()=" + getAddressLine1() + ", getAddressLine2()="
			+ getAddressLine2() + ", getState()=" + getState() + ", getCity()=" + getCity() + ", getCountry()="
			+ getCountry() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}
public String getAddressLine1() {
	return addressLine1;
}
public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}
public String getAddressLine2() {
	return addressLine2;
}
public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}


}
