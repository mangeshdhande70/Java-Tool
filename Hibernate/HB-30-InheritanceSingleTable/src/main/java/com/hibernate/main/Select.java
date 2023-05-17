package com.hibernate.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.model.Payment;
import com.hibernate.util.HibernateUtil;

public class Select {
	
	 private static Session session = null;
		
		@SuppressWarnings("unchecked")
		public static void main(String[] args) {
				
			session = HibernateUtil.getSession();
			
			try {

				Query<Payment> query1 = session.createQuery("FROM com.hibernate.model.Payment");				
				List<Payment> list1 = query1.getResultList();
				list1.forEach(System.out::println);
				
				System.out.println("\n\n**** CHEQUE ******");
				Query<Payment> query2 = session.createQuery("FROM com.hibernate.model.ChequePayment");				
				List<Payment> list2 = query2.getResultList();
				list2.forEach(System.out::println);
				
				
				
				System.out.println("\n\n**** CARD ******");
				Query<Payment> query3 = session.createQuery("FROM com.hibernate.model.CardPayment");				
				List<Payment> list3 = query3.getResultList();
				list3.forEach(System.out::println);
				
				
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
