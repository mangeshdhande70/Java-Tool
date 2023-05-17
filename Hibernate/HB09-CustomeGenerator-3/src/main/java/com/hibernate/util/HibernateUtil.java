package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.model.StudentGenerator_3;

public class HibernateUtil {
	
	private static Session session ;
	
	private HibernateUtil() {}
	
	
	public static Session getSession() {
		
	   session = new Configuration().addAnnotatedClass(StudentGenerator_3.class).buildSessionFactory().openSession();
		
		
		return session;
	}
	
	
	public static void closeSession(Session session ) {
		
		if (session!=null) 
			session.close();
		
		
	}
	
	
	
	

}
