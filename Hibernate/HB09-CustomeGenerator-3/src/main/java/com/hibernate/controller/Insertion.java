package com.hibernate.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;
import com.model.StudentGenerator_3;

public class Insertion {
	
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		
		
		StudentGenerator_3 studentGenric = new StudentGenerator_3();
		studentGenric.setName("Aash");
		
		Transaction transaction = session.beginTransaction();
		
		session.save(studentGenric);
		
		transaction.commit();
		
		
		
		
		
	}

}
