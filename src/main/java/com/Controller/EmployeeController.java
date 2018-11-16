package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.entity.Employee;
import com.java.spring.service.EmployeeService;

@ComponentScan(basePackages = "com.java.spring.service")
@ComponentScan(basePackages = "com.java.spring.service.EemplyeeService")
@RestController
@RequestMapping(value={"/employee"})
public class EmployeeController {
	@Autowired
	private EmployeeService EmpService; 
	
	@PostMapping(value="/create",headers="Accept=application/json")
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder){
		EmpService.createEmployee(employee);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
}
