package com.hibernate.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Address;
import com.hibernate.model.StudentInfo;
import com.hibernate.util.HibernateUtil;

public class Insertion {
	
  private static Session session = null;
  private static Transaction transaction = null;
	
	public static void main(String[] args) {
		
		boolean flag = false;
		
		
		Address address = new Address();
		address.setCity("Nagpur");
		address.setPinCode(440029);
		address.setState("Maharashtra");
		
		
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setName("Ankit");
		studentInfo.setAddress(address);
		
		
		
		session = HibernateUtil.getSession();
		
		try {
		if (session!=null) 
			transaction = session.beginTransaction();
		
		if (transaction!=null) {
			session.save(studentInfo);
			flag = true;
		}
		
		}catch (HibernateException e) {
				e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object added successfully");
			}else {
				transaction.rollback();
				System.out.println("Faild to added object in DB");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
