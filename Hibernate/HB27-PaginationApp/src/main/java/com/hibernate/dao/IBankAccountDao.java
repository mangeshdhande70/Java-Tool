package com.hibernate.dao;

import java.util.List;

import com.hibernate.model.BankAccount;

public interface IBankAccountDao {
	
	public List<BankAccount> getPageData (int pageSize , int startPos);
	
	public Long getTotalRecordCount();

}
