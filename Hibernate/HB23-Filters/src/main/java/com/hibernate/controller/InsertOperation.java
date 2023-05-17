package com.hibernate.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.AccountStatus;
import com.hibernate.model.AccountType;
import com.hibernate.model.BankAccount;
import com.hibernate.util.HibernateUtil;

public class InsertOperation {
	
	public static void main(String[] args) {
		
		
		
		Session session = HibernateUtil.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		BankAccount bankAccount = new BankAccount();
		bankAccount.setName("Tapya Mehta");
		bankAccount.setAccountStatus(AccountStatus.ACTIVE);
		bankAccount.setBalance(50000d);
		bankAccount.setBranchName("Nagpur");
		bankAccount.setAccountType(AccountType.SALARY);
		
		
		session.save(bankAccount);
		
		transaction.commit();
		
		
	}
	
	
	

}
