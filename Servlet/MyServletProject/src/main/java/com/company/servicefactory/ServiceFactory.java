package com.company.servicefactory;

import com.company.service.IService;
import com.company.service.ServiceImpl;

public abstract class ServiceFactory {
	
	
	public static IService getService() {
	
	  IService iService = new ServiceImpl();
	  
	  return iService;
	    
	}

	
}
