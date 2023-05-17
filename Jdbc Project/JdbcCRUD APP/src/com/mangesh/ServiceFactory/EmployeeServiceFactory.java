package com.mangesh.ServiceFactory;

import com.mangesh.service.EmployeeServiceImpl;
import com.mangesh.service.IEmployeeService;

public class EmployeeServiceFactory {
	
	
	private EmployeeServiceFactory() {}
	
	private static  IEmployeeService iEmployeeService = null;
	
	
	public static IEmployeeService getEmployeeService() {
		
		
		iEmployeeService = new EmployeeServiceImpl();
		
		return iEmployeeService;
		
	}
	
	
}
