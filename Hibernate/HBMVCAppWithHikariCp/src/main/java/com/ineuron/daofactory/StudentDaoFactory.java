package com.ineuron.daofactory;

import com.ineuron.persis.IStudentDao;
import com.ineuron.persis.StudentDaoImpl;
public class StudentDaoFactory {

	private StudentDaoFactory() {}

	private static IStudentDao studentDao = null;

	public static IStudentDao getStudentDao() {
		if (studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
}
