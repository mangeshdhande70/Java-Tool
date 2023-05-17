package com.mangesh.controller;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mangesh.model.Employee;
import com.mangesh.util.HibernateUtil;

public class SaveOrUpdate {

	
	public static void main(String[] args) throws IOException {

		Transaction transaction = null;
		boolean flag = false;

		try {
			Session session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if(transaction!=null) {
				Employee employee = new Employee();
				employee.setEmployeeId(5);
				employee.setEmpolyeeName("Akash");
				employee.setExperience(5);
		    	session.saveOrUpdate(employee); 
		    	flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated to database....");
			} else {
				transaction.rollback();
				System.out.println("Object not updated to database...");
			}


			HibernateUtil.closeSession(null);
			HibernateUtil.closeSessionFactory();

		}
	}

}
