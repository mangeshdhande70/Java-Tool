package com.mangesh.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mangesh.model.Employee;
import com.mangesh.util.HibernateUtil;

public class Update {

	
	public static void main(String[] args) {

		Transaction transaction = null;
		Employee employee = null;
		int id = 1;

		try {
			Session session = HibernateUtil.getSession();

			if (session != null)
				employee = session.get(Employee.class, id);

			if (employee != null) {
				transaction = session.beginTransaction();

				employee.setEmpolyeeName("AKash");
				employee.setExperience(2);
				
				session.update(employee);
			}else {
				System.out.println("Record Not Found For given id ");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null)
				transaction.commit();

			HibernateUtil.closeSession(null);
			HibernateUtil.closeSessionFactory();

		}
	}

}
