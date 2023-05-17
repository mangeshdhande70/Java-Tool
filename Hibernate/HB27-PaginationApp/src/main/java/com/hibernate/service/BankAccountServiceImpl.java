package com.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.dao.BankAccountDaoImpl;
import com.hibernate.dao.IBankAccountDao;
import com.hibernate.dto.BankAccountDTO;
import com.hibernate.model.BankAccount;

public class BankAccountServiceImpl implements IBankAccountService {
	
	private IBankAccountDao dao;
	
	public BankAccountServiceImpl() {
		dao = new BankAccountDaoImpl();
	}
	
	@Override
	public long fetchPageCount(int pageSize) {
		
		Long totalRecordCount = dao.getTotalRecordCount();
        Long pageCount = totalRecordCount/pageSize;// 23/3 = 7
         
         if (totalRecordCount%pageSize !=0) //8
        	 pageCount++;

		return pageCount;
	}

	@Override
	public List<BankAccountDTO> fetchPageData(int pageSize, int pageNo) {
	
		int startPos = 0;
		startPos = (pageNo * pageSize) - pageSize;
		List<BankAccountDTO> listsAccountDTOs = new ArrayList<BankAccountDTO>();
		List<BankAccount> list = dao.getPageData(pageSize, startPos);
	
		list.forEach(entity->{
			BankAccountDTO dto = new BankAccountDTO();
			dto.setAccountNo(entity.getAccountNo());
			dto.setAccountStatus(entity.getAccountStatus());
			dto.setAccountType(entity.getAccountType());
			dto.setBalance(entity.getBalance());
			dto.setBranchName(entity.getBranchName());
			dto.setName(entity.getName());
			listsAccountDTOs.add(dto);
		});
		
		return listsAccountDTOs;
	}

}
