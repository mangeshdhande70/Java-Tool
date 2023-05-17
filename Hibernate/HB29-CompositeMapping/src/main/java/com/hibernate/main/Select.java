package com.hibernate.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.model.StudentInfo;
import com.hibernate.util.HibernateUtil;

public class Select {
	
	 private static Session session = null;
		
		@SuppressWarnings("unchecked")
		public static void main(String[] args) {
				
			session = HibernateUtil.getSession();
			
			try {

				Query<StudentInfo> query = session.createQuery("FROM com.hibernate.model.StudentInfo WHERE address.city=:city");
			
				query.setParameter("city", "Nagpur");
				
				List<StudentInfo> list = query.list();
				
				list.forEach(System.out::println);
				
				
			}catch (HibernateException e) {
					e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
		
				HibernateUtil.closeSession(session);
				HibernateUtil.closeSessionFactory();
			}

		}


}
