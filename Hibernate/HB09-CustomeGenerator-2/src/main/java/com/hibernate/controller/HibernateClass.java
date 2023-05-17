package com.hibernate.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.StudentGenricWithDate;

public class HibernateClass {
	
	
	public static void main(String[] args) {
		
		Session session = new Configuration().addAnnotatedClass(StudentGenricWithDate.class).buildSessionFactory().openSession();
		
		
		StudentGenricWithDate studentGenric = new StudentGenricWithDate();
		studentGenric.setName("Mangesh");
		
		Transaction transaction = session.beginTransaction();
		
		session.save(studentGenric);
		
		transaction.commit();
		
		
		
		
		
	}

}
