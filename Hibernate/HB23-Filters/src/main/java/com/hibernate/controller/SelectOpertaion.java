package com.hibernate.controller;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.model.BankAccount;
import com.hibernate.util.HibernateUtil;

public class SelectOpertaion {
	
	
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
		
		filter.setParameter("accType1", "blocked");
		filter.setParameter("accType2" , "closed");
		
		@SuppressWarnings("unchecked")
		Query<BankAccount> query = session.createQuery("FROM com.hibernate.model.BankAccount where Balance>=:balance");
		
		query.setParameter("balance", 4000d);
		
		List<BankAccount> list = query.list();
		
		list.forEach(System.out::println);
		
	}
	
	
	

}
