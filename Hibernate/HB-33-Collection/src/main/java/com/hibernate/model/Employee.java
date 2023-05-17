package com.hibernate.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;

@Entity
@Table(name = "EMPLOYEE_INFO_TABLE2")
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "Company")
	private final String companyName = "Infosys.Ltd";
	
//	@ElementCollection
//	@Column(name = "friend_name")
//	@CollectionTable(name = "EMP_FRNDS", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "eid"))
//	@OrderColumn(name = "friend_no")
//	@ListIndexBase(value = 1)
//	private List<String> friendList;
	
	
	@ElementCollection
	@Column(name = "freind_name")
	@CollectionTable(name = "EMP_FRNDS" ,joinColumns =  @JoinColumn(name  = "employee_id" , referencedColumnName = "employeeId"))
	@OrderColumn(name = "freind_no")
	@ListIndexBase(value = 1)
	private List<String> freindList;
	
	
	@ElementCollection
	@Column(name = "contact_no")
	@CollectionTable(name = "CONTACT_NO_TABLE", joinColumns = @JoinColumn(name  = "employee_id" , referencedColumnName = "employeeId"))
	private Set<Long> contactNo;
	
	
	
	@ElementCollection
	@Column(name = "account_no")
	@CollectionTable(name = "BANK_ACCOUNT_NEW", joinColumns = @JoinColumn(name ="employee_id", referencedColumnName = "employeeId"))
	@MapKeyColumn(name = "bank_name")
	private Map<String, Long> bankAccount;

		

}
