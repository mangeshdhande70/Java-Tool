package com.mangesh.StudentDaoFactory;

import com.mangesh.persistent.EmployeeDaoImpl;
import com.mangesh.persistent.IEmployeeDao;

public class EmployeeDaoFactory {
	
	
	private static IEmployeeDao iEmployeeDao = null;
	
	
	public static IEmployeeDao getEmployeeDao() {
		
		iEmployeeDao = new EmployeeDaoImpl();
		
		return iEmployeeDao;
		
	}
	
	
	
	

}
