package com.hibernate.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.StudentGenric;

public class HibernateClass {
	
	
	public static void main(String[] args) {
		
		Session session = new Configuration().addAnnotatedClass(StudentGenric.class).buildSessionFactory().openSession();
		
		
		StudentGenric studentGenric = new StudentGenric();
		studentGenric.setName("Mangesh");
		
		Transaction transaction = session.beginTransaction();
		
		session.save(studentGenric);
		
		transaction.commit();
		
		
		
		
		
	}

}
