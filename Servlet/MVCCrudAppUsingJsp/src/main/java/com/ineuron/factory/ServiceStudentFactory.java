package com.ineuron.factory;

import com.ineuron.service.IServiceStudent;
import com.ineuron.service.ServiceStudentImpl;

public abstract class ServiceStudentFactory {

	public static IServiceStudent getService() {

		return new ServiceStudentImpl();

	}

}
