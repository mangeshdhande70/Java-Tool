package com.ineuron.factory;

import com.ineuronservice.IStudentService;
import com.ineuronservice.StudentServiceImpl;


//Abstraction logic of implementation
public class StudentServiceFactory {

	//make constuctor private to avoid object creation
	private StudentServiceFactory() {

	}

	private static IStudentService studentService = null;

	public static IStudentService getStudentService() {
		
		//singleton pattern code
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

}
