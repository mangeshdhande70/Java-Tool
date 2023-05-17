package com.mangesh.studentfactory;

import com.mangesh.dto.Employee;

public abstract class EmployeeFactory {
	
	
	public static Employee getEmployee() {
		
		return new Employee();
	
		
	}
	

}
