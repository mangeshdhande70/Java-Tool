package com.company.studentdaofactory;

import com.company.persistent.IStudentDao;
import com.company.persistent.StudentDao;

public abstract class StudentDaoFactory {
	
	
	
	public static IStudentDao getStudentDao() {
		
		
		IStudentDao iStudentDao = new StudentDao();
		
		return iStudentDao;
		
		
	}
	
	

}
