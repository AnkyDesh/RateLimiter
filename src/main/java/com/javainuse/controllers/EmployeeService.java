package com.javainuse.controllers;

import org.springframework.stereotype.Service;

import com.javainuse.model.Employee;

@Service
public class EmployeeService {
	
	public Employee saveEmp(Employee employee) {
		try {
	  employee.setEmpId("2");
		employee.setName("Anil");
		employee.setDesignation("javaDevloper");
		employee.setSalary(100000);
		return employee;
	
		
	}catch (Exception e){
		System.out.println(e.getMessage()+"value not is empty");
	}
		return employee;
		}
	

}
