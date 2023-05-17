package com.hibernate.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.model.InsurancePolicy2;
import com.hibernate.util.HibernateUtil;

public class UniqueResult {

	public static void main(String[] args) throws Exception {

		Session session = null;
		int id = 12;

		session = HibernateUtil.getSession();
		try {


			// prepare query
			@SuppressWarnings("unchecked")
			Query<InsurancePolicy2> query = session.createQuery("FROM com.hibernate.model.InsurancePolicy2 WHERE pid=:ID");
			
			query.setParameter("ID", id);
			
			// execute the query
			 InsurancePolicy2 result = query.uniqueResult();
			
			//process query
			if (result !=null) {
				System.out.println(result);	
			}else {
				System.out.println("Record not exist in DB for the given id :: "+id);
			}
			

		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
