package com.hibernate.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CHEQUE_PAYMENT_TPCC")
@Data
public class ChequePayment extends Payment implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long chequeId;
	
	private String chequeType;
	
	private LocalDate date;

}
