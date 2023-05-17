package com.hibernate.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.model.BankAccount;
import com.hibernate.util.HibernateUtil;

public class SelectOpertaion {
	
	
	
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
		 session = HibernateUtil.getSession();
		
		 @SuppressWarnings("unchecked")
		Query<BankAccount> query = session.createQuery("FROM com.hibernate.model.BankAccount");
		 
		 List<BankAccount> list = query.list();
		 
		 list.forEach(System.out::println);
		 	
	}catch (HibernateException e) {
		e.printStackTrace();
	}catch (Exception e) {
        e.printStackTrace();
	}finally {
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
		
	}
	}
	
	
	

}
