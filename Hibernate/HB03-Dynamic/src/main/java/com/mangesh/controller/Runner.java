package com.mangesh.controller;

import com.mangesh.model.EmployeeDynamic;
import com.mangesh.persist.EmployeeDao;
import com.mangesh.util.EmployeeDaoUtil;

public class Runner {
	
	public static void main(String[] args) {
		
		
		EmployeeDao employeeDao = null;
		
		EmployeeDynamic employee = new EmployeeDynamic();
		employee.setEmployeeId(2);
		employee.setEmpolyeeName("Akash");
		employee.setSalary(100000f);
		
	
		employeeDao = EmployeeDaoUtil.getEmployeeDao();
		
		employeeDao.addEmployee(employee);
		
		
		
	}

}
