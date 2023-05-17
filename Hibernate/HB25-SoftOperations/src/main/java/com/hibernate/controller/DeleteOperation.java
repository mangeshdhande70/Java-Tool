package com.hibernate.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.BankAccount;
import com.hibernate.util.HibernateUtil;

public class DeleteOperation {
	
	
	
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
		 session = HibernateUtil.getSession();
		 if (session != null) 
		    transaction = session.beginTransaction();
		 
		 if (transaction!=null) {
			 	BankAccount bankAccount = session.get(BankAccount.class, 3000006L);
			    session.delete(bankAccount);
			    flag = true;	
		}
			
	}catch (HibernateException e) {
		e.printStackTrace();
	}catch (Exception e) {
        e.printStackTrace();
	}finally {
		
		if (flag) {
			transaction.commit();
			System.out.println("  Object Status changed to CLOSED state ");
		}else {
			transaction.rollback();
			System.out.println("Failed to Delete");
		}
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
		
	}
	}
	
	
	

}
