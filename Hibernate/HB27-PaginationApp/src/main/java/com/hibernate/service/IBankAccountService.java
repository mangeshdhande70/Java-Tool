package com.hibernate.service;

import java.util.List;

import com.hibernate.dto.BankAccountDTO;

public interface IBankAccountService {
	
	
	public long fetchPageCount(int pageSize);
	public List<BankAccountDTO> fetchPageData(int pageSize , int pageNo);

}
