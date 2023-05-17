package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;

import lombok.Data;

@Entity
@Data
@Table(name = "ICICI_BANK")
@FilterDef(name = "FILTER_BANK_ACCOUNT_STATUS" , 
              parameters = {@ParamDef(type = "string", name = "accType1"),
                            @ParamDef(type = "string" , name = "accType2") 		  
              }
          )
@Filter(name = "FILTER_BANK_ACCOUNT_STATUS" , condition = "Account_Status NOT IN(:accType1, :accType2)")
public class BankAccount {
	
	@Id
	@GenericGenerator(name = "gen1" , strategy = "com.hibernate.util.MyGenerator")
	@GeneratedValue(generator = "gen1")
	@Column(name = "account_number")
	private Long accountNo;
	
	@Column(name = "Account_Holder_Name")
	private String name;
	
	@Column(name = "Balance")
	private Double balance;
	
	@Column(name = "Type")
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	@Column(name = "Branch")
	private String branchName;
	
	@Column(name = "IFSCE_CODE")
	private final String ifscCode = "icici00109";
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Account_Status")
	private AccountStatus accountStatus;
	
	
	

}
