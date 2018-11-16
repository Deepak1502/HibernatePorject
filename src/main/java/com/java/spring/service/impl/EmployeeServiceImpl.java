package com.java.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Employee;
import com.java.spring.dao.EmployeeDao;
import com.java.spring.service.EmployeeService;

@ComponentScan(basePackages = "com.java.spring.dao")
@ComponentScan(basePackages = "com.java.spring.DaoImpl")
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
    EmployeeDao empDao;
	
	@Override
	public void createEmployee(Employee emp) {
		empDao.addEmployee(emp);;
		
	}

	@Override
	public List<Employee> getEmployees() {
		
		return empDao.getEmployees();
	}

	@Override
	public Employee findById(int id) {
		
		return empDao.findById(id);
	}

	@Override
	public Employee update(Employee emp, int id) {
		
		return empDao.update(emp, id);
	}

	@Override
	public void deleteEmployeeById(int id) {
		
		empDao.delete(id);
		
	}

	@Override
	public Employee updatePartially(Employee emp, int id) {
		
		return empDao.updateEmployee(emp, id);
	}

}
