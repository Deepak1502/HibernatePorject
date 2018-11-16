package com.java.spring.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.entity.Employee;
import com.java.spring.dao.EmployeeDao;

@ComponentScan(basePackages = "com.java.spring.configuration")
@ComponentScan(basePackages = "com.java.spring.dao")
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		session.save(emp);
	}

	@Override
	public List<Employee> getEmployees() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> emp = session.createCriteria(Employee.class).list();
		return emp;
	}

	@Override
	public Employee findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp=session.get(Employee.class, id);
		return emp;
	}

	@Override
	public Employee update(Employee emp, int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee=session.load(Employee.class, id);
		employee.setId(emp.getId());
		employee.setName(emp.getName());
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee emp, int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee=session.load(Employee.class, id);
		employee.setName(emp.getName());
		return employee;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp=session.get(Employee.class, id);
		session.delete(emp);
		
	}

}
