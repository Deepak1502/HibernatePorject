package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserRecord;

  
@RestController  
public class SpringBootJdbcController {  
	@Autowired
	
	DataService dataService;
    @Autowired  
    JdbcTemplate jdbc;    
    @RequestMapping("/insert")  
    public String index(){  
        jdbc.execute("insert into user(name,email)values('deepak','deepak_sha@hcl.com')");  
        return"data inserted Successfully";  
    } 
    // to insert the user records in db.
    @RequestMapping(value="/add-user", method=RequestMethod.POST)  
    public void addUser(@RequestBody UserRecord userRecord){  
    	dataService.addUser(userRecord);  
    }
    
    // to fetch user records from db.
    @RequestMapping(value="/get-user")  
    public List<UserRecord> getAllUser(){  
    	return dataService.getUser();  
    }
}