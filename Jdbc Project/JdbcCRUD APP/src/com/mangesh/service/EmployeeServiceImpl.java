package com.mangesh.service;


import java.util.ArrayList;
import com.mangesh.StudentDaoFactory.EmployeeDaoFactory;
import com.mangesh.dto.Employee;
import com.mangesh.persistent.IEmployeeDao;



public class EmployeeServiceImpl implements IEmployeeService{
	
	
	IEmployeeDao iEmployeeDao = EmployeeDaoFactory.getEmployeeDao();

	@Override
	public String addingEmployee(String name, String unit, String doj, String dob, String photoPath, String idProofPaht) {
		
		
		String result = iEmployeeDao.addingEmployee(name, unit, doj, dob, photoPath, idProofPaht);
		
		return result;
	}

	@Override
	public Employee searchEmployeeById(Integer empId) {
		
		return iEmployeeDao.searchEmployeeById(empId);
	
		 
	}

	@Override
	public String updateEmployee(Integer empId, String doj, String dob, String photoPath,String idProofPaht) {
		
		return iEmployeeDao.updateEmployee(empId, doj, dob, photoPath, idProofPaht);
	}

	@Override
	public String deleteEmployee(Integer empId) {
		return iEmployeeDao.deleteEmployee(empId);
	}
	
	
	
	@Override
	public ArrayList<Employee> getAllEmployee(){
		
		return iEmployeeDao.getAllEmployees();
	}


}
