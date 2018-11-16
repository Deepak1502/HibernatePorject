package com.entity;

import javax.persistence.*;

@Entity  
@Table(name = "employee101")  
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING) 
@DiscriminatorValue(value="employee")

public class Employee {

	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "id")  
	private int id;  
	/*@Column(name = "regularEmployee")
	private  Regular_Employee regularEmployee;
	
	public Regular_Employee getRegularEmployee() {
		return regularEmployee;
	}

	public void setRegularEmployee(Regular_Employee regularEmployee) {
		this.regularEmployee = regularEmployee;
	}
	@Column(name = "contrctEmployee")
	private  Contract_Employee contrctEmployee;

	public Contract_Employee getContrctEmployee() {
		return contrctEmployee;
	}

	public void setContrctEmployee(Contract_Employee contrctEmployee) {
		this.contrctEmployee = contrctEmployee;
	}
*/
	@Column(name = "name")  
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}  
}
