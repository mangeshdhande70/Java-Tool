package com.hibernate.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtilClass;

public class Select {
	
	 private static Session session = null;
		
		@SuppressWarnings("unchecked")
		public static void main(String[] args) {
				
			session = HibernateUtilClass.getSession();
			
			try {

				Query<Employee> query3 = session.createQuery("FROM com.hibernate.model.Employee");				
				List<Employee> list3 = query3.getResultList();
				list3.forEach(System.out::println);
				
				
			}catch (HibernateException e) {
					e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
		
				HibernateUtilClass.closeSession(session);
				HibernateUtilClass.closeSessionFactory();
			}

		}


}
