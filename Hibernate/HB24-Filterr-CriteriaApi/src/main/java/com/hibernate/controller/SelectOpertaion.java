package com.hibernate.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.hibernate.model.BankAccount;
import com.hibernate.util.HibernateUtil;

public class SelectOpertaion {
	
	
	
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
		 session = HibernateUtil.getSession();
		
		Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
		
		filter.setParameter("accType1", "blocked");
		filter.setParameter("accType2" , "closed");
		
	
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(BankAccount.class);
		
		Criterion cond1 = Restrictions.ge("balance", 40000d);
		criteria.add(cond1);
		
		
		@SuppressWarnings("unchecked")
		List<BankAccount> bankAccounts = criteria.list();
		bankAccounts.forEach(System.out::println);
		
		
		
		System.out.println("\n\nAfter Disable");
		
		session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
		
		
		@SuppressWarnings("deprecation")
		Criteria criteria1 = session.createCriteria(BankAccount.class);
		
		Criterion cond2 = Restrictions.ge("balance", 40000d);
		criteria.add(cond2);
		
		
		@SuppressWarnings("unchecked")
		List<BankAccount> bankAccounts1 = criteria1.list();
		bankAccounts1.forEach(System.out::println);
		
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
