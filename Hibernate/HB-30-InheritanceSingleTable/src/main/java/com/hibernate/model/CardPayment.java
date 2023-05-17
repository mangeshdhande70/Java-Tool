package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;


@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("CARD")

public class CardPayment extends Payment implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long cardNo;
	private String cardHoldeName;
	private String cardType;
	
	
	
	
	
	
	
	

}
