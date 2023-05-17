package com.hibernate.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.PersonInfoVersion;
import com.hibernate.util.HibernateUtil;

public class update {
	
private static Transaction transaction = null;
private static	Session session = null;
private static PersonInfoVersion personInfoVersion  = null;	
private static boolean flag = false;
	public static void main(String[] args) {
		
		int id = 1;
		
	try {	
		session = HibernateUtil.getSession();
		transaction = session.beginTransaction();
		
		if (session!=null)
			 personInfoVersion = session.get(PersonInfoVersion.class, id);
		
		if (personInfoVersion.getVersionCount() >= 3) {
			System.out.println("You exceed your limit...Thankyou");
			return;
			
		}
		
		if (personInfoVersion!=null) {
			personInfoVersion.setCallerTune("Shape of U......");
			flag = true;
		}else {
			System.out.println("Record Not found for given id :: "+id);
		}
	}catch (HibernateException e) {
		e.printStackTrace();
	}catch (Exception e) {
        e.printStackTrace();
	}finally {
		if (flag) {
			transaction.commit();
		}
	}
		
	}
	
	

}
