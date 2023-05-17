package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Employee;

public  class HibernateUtilClass {
	
	private HibernateUtilClass() {
		
	}

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		System.out.println("Class Loaded");
		sessionFactory = new Configuration().addAnnotatedClass(Employee.class).buildSessionFactory();
	}

	public static Session getSession() {

		if (sessionFactory != null) 
			 session = sessionFactory.openSession();
	
		return session;
	}
	
	public static void closeSession(Session session) {

		if (session != null) {
			session.close();
		}
	}

	public static void closeSessionFactory() {

		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
