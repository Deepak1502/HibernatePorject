package com.java.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Employee;
@Service
public interface EmployeeService {
	public void createEmployee(Employee emp);
    public List<Employee> getEmployees();
    public Employee findById(int id);
    public Employee update(Employee emp, int id);
    public void deleteEmployeeById(int id);
    public Employee updatePartially(Employee emp, int id);
}
