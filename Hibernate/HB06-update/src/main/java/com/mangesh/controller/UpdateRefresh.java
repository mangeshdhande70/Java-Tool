package com.mangesh.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mangesh.model.Employee;
import com.mangesh.util.HibernateUtil;

public class UpdateRefresh {

	
	public static void main(String[] args) {

		Transaction transaction = null;
		Employee employee = null;
		Session session = null;
		int id = 1;

		try {
			session = HibernateUtil.getSession();
			employee = session.get(Employee.class, id);
			System.out.println("Before updation in the table :: " + employee);

			if (employee != null) {
				System.in.read();// go to DB and make the change

				session.refresh(employee);

				System.out.println("After updation in the table :: " + employee);

			} else {
				System.out.println("Record available for the given id :: " + id);
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
