package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CARD_PAYMENT_TPCC")
public class CardPayment extends Payment implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long cardNo;
	private String cardHoldeName;
	private String cardType;
	

}
