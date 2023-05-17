package com.hibernate.customeGen;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyCustomeIdGen implements IdentifierGenerator {

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		System.out.println("MuCtome CAll");
		
		String id = "IN-01";
		return id;
	}

}
