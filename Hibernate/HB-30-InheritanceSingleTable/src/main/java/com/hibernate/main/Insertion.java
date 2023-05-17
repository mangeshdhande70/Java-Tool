package com.hibernate.main;



import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.CardPayment;
import com.hibernate.model.ChequePayment;
import com.hibernate.util.HibernateUtil;

public class Insertion {
	
  private static Session session = null;
  private static Transaction transaction = null;
	
	public static void main(String[] args) {
		
		boolean flag = false;
		
		CardPayment cardPayment = new CardPayment();
		cardPayment.setPaymentId(1234);
		cardPayment.setAmount(9819000D);
		
		cardPayment.setCardHoldeName("Mangesh Dhande");
		cardPayment.setCardNo(897654L);
		cardPayment.setCardType("VISA");
		
		
		ChequePayment chequePayment = new ChequePayment();
		chequePayment.setPaymentId(234567);
		chequePayment.setAmount(098765D);
		
		chequePayment.setChequeId(90876L);
		chequePayment.setChequeType("SELF");
		chequePayment.setDate(LocalDate.of(2023, 4, 15));
		
		
		
		session = HibernateUtil.getSession();
		
		try {
		if (session!=null) 
			transaction = session.beginTransaction();
		
		if (transaction!=null) {
			session.save(cardPayment);
			session.save(chequePayment);
			flag = true;
		}
		
		}catch (HibernateException e) {
				e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object added successfully");
			}else {
				transaction.rollback();
				System.out.println("Faild to added object in DB");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
