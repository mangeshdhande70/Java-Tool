package com.mangesh.service;


import java.util.ArrayList;

import com.mangesh.dto.Employee;


public interface IEmployeeService {
	
	
	
	//Operations to be implemented
	public String addingEmployee(String name, String unit, String doj , String dob , String photoPath , String idProofPaht);
	
	public Employee searchEmployeeById(Integer empId);
	
	public String updateEmployee(Integer empId , String doj , String dob , String photoPath , String idProofPaht);
	
	public String deleteEmployee(Integer empId);
	
	public ArrayList<Employee> getAllEmployee();

}
