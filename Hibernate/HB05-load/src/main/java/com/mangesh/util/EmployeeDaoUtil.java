package com.mangesh.util;

import com.mangesh.persist.EmployeeDao;
import com.mangesh.persist.EmployeeDaoImpl;

public class EmployeeDaoUtil {
	
	private EmployeeDaoUtil() {}
	
	public static EmployeeDao getEmployeeDao() {
		return new EmployeeDaoImpl();
	}
}
