package com.ineuron.dtofactory;

import com.ineuron.persis.IStudentDao;
import com.ineuron.persis.StudentDaoImpl;

public abstract class StudentDaoFactory {

	public static IStudentDao getStudentDao() {

		return new StudentDaoImpl();

	}

}
