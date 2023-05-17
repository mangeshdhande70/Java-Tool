package com.hibernate.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("CHEQUE")
public class ChequePayment extends Payment implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long chequeId;
	
	private String chequeType;
	
	private LocalDate date;

}
