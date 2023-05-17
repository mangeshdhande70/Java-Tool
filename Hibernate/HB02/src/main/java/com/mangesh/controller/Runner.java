package com.mangesh.controller;

import com.mangesh.model.Employee;
import com.mangesh.persist.EmployeeDao;
import com.mangesh.util.EmployeeDaoUtil;

public class Runner {
	
	public static void main(String[] args) {
		
		
		EmployeeDao employeeDao = null;
		
		Employee employee = new Employee();
		
		employee.setEmpolyeeName("Ankit Naitam");
		employee.setExperience(0);
		employee.setSalary(100000f);
		
	
		employeeDao = EmployeeDaoUtil.getEmployeeDao();
		
		employeeDao.addEmployee(employee);
		
		
		
	}

}
