package com.hibernate.controller;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.InsurancePolicy2;
import com.hibernate.util.HibernateUtil;

public class ClientApp2 {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		Integer id = null;
		Boolean flag = false;

		session = HibernateUtil.getSession();
		
		try {
			transaction = session.beginTransaction();
			
			InsurancePolicy2 policy = session.get(InsurancePolicy2.class, 1,LockMode.UPGRADE_NOWAIT);
			System.out.println(policy);
			
			policy.setTenure(24);
			flag =true;

		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to  the database with the id :: " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
