package com.mangesh.controller;

import com.mangesh.model.Employee;
import com.mangesh.persist.EmployeeDao;
import com.mangesh.util.EmployeeDaoUtil;

public class Runner {
	
	public static void main(String[] args) {
		
		int id = 1;
		EmployeeDao employeeDao = null;
		
//		Employee employee = new Employee();
//		
//		employee.setEmpolyeeName("Ankit Naitam");
//		employee.setExperience(0);
//		employee.setSalary(100000f);
		
	
		employeeDao = EmployeeDaoUtil.getEmployeeDao();
		
		Employee employee2 = employeeDao.getEmployee(id);
		
		if (employee2!=null) 
			System.out.println(employee2);
		else {
			System.out.println("Record not found for id :: "+id);
		}
		
		
		
	}

}
