package com.hibernate.dto;

import com.hibernate.model.AccountStatus;
import com.hibernate.model.AccountType;

import lombok.Data;

@Data
public class BankAccountDTO {
	
	private Long accountNo;
	private String name;
	private Double balance;
	private AccountType accountType;
	private String branchName;
	private final String ifscCode = "icici00109";
	private AccountStatus accountStatus;
	

}
