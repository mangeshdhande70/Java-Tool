package com.hibernate.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.model.InsurancePolicy2;
import com.hibernate.util.HibernateUtil;

public class ClientApp1 {

	public static void main(String[] args) throws Exception {

		Session session = null;

		session = HibernateUtil.getSession();
		try {


			// prepare query
			Query query = session.createQuery("FROM com.hibernate.model.InsurancePolicy2");
			
			// execute the query
			List<InsurancePolicy2> list = query.list();
			
			//process query
			list.forEach(System.out::println);
			

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
