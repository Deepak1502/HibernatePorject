package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.entity.User;
import com.entity.UserAddress;
import com.java.spring.service.AddressService;
import com.java.spring.service.UserService;

@ComponentScan(basePackages = "com.java.spring.service")
@RestController
@RequestMapping(value={"/address"})
public class AddressController {

	@Autowired
	private AddressService addressService;
	@Qualifier("addressService")

	@GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAddress> getUserAddress(@PathVariable("id") int id ){
		UserAddress userAddress=addressService.findById(id);
		if(userAddress==null) {
			return new ResponseEntity<UserAddress>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserAddress>(userAddress,HttpStatus.OK);
	}

	@PostMapping(value="/createAdrress",headers="Accept=application/json")
	public ResponseEntity<Void> createAddress(@RequestBody UserAddress userAddress, UriComponentsBuilder ucBuilder){
		addressService.createAddress(userAddress);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/userAddress/{id}").buildAndExpand(userAddress.getAddressId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}
	@GetMapping(value="/get",headers="Accept=application/json")
	public List<UserAddress> getAllAddress(){
		List<UserAddress> task=addressService.getUserAddress();
		return task;
	}
	
	
	@PutMapping(value="/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>updateUserAddress(@RequestBody UserAddress userAddress){
		int userAddressId=userAddress.getAddressId();
		UserAddress address=addressService.findById(userAddressId);
		if(address==null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		addressService.updateAddress(userAddress, userAddressId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
