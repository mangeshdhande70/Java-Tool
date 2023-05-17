package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "CARD_PAYMENT_JOINED")
@PrimaryKeyJoinColumn(name = "payment_id", referencedColumnName = "paymentId" )
@DiscriminatorValue("CARD")
public class CardPayment extends Payment implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long cardNo;
	private String cardHoldeName;
	private String cardType;
	

}
