package com.May2026.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees3")
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer emp_id;
    private String emp_name;
    private String email;
    private String department;
    private Double salary;
    private Integer dept_id;
    
    public Employee()
    {
    	
    }
	
	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setStatus(Object status) {
		// TODO Auto-generated method stub
		
	}
    
    
}
