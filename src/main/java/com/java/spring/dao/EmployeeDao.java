package com.java.spring.dao;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee emp);
    public List<Employee> getEmployees();
    public Employee findById(int id);
    public Employee update(Employee emp, int id);
    public Employee updateEmployee(Employee emp, int id);
    public void delete(int id);
}
