package com.hibernate.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.util.HibernateUtil;

public class ClientApp1 {

	public static void main(String[] args) throws Exception {

		Session session = null;

		session = HibernateUtil.getSession();
		try {


			// prepare query
			@SuppressWarnings("unchecked")
			Query<Integer> query = session.createQuery("SELECT tenure FROM com.hibernate.model.InsurancePolicy2 WHERE tenure>:Tenure");
			
			query.setParameter("Tenure", 10);
			
			// execute the query
			List<Integer> list = query.list();
			
			List<Integer> list2 = query.getResultList();
			
			System.out.println("Tenure");
			
			//process query
			list.forEach(System.out::println);
			
			System.out.println("\n\n\n*******************");
			System.out.println("Tenure");
			list2.forEach(System.out::println);

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
