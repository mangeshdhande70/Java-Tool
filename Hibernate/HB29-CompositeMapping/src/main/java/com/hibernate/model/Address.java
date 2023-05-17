package com.hibernate.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	
	private String city;
	private String state;
	private Integer pinCode;

}
