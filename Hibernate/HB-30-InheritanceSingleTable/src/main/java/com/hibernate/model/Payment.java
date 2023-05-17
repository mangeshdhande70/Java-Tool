package com.hibernate.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PAYMENT_SINGLE_TABLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_mode" , discriminatorType = DiscriminatorType.STRING )
public abstract class Payment {

	@Id
	private Integer paymentId;
	
	private Double amount;
	
	
}
