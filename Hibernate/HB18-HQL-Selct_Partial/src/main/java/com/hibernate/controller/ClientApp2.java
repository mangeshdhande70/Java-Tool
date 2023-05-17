package com.hibernate.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.util.HibernateUtil;

public class ClientApp2 {

	public static void main(String[] args) throws Exception {

		Session session = null;

		session = HibernateUtil.getSession();
		try {


			// prepare query
			@SuppressWarnings("unchecked")
			Query<Object[]> query = session.createQuery("SELECT pname,ptype,tenure FROM com.hibernate.model.InsurancePolicy2");
			
			
			// execute the query
			List<Object[]> list = query.list();
			
			//process query
			System.out.println();
			System.out.println("PNAME\t\tType\tTenure");
			list.forEach(row-> {
				for(Object object : row) {
			         System.out.print(object+"\t");
				}
				System.out.println();
			});
			

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
