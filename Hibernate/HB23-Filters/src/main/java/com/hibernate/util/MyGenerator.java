package com.hibernate.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Long genId = null;
	
	

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		connection = session.connection();
		int id = 3000000;
		String sqlQuery = "SELECT account_number FROM ICICI_BANK";
		
			
			try {
				if (connection !=null) 
				preparedStatement = connection.prepareStatement(sqlQuery);
				
				if (preparedStatement!=null) 
					resultSet  = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					id = resultSet.getInt(1);
				}	
				genId = (long) (id+1);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return genId ;
	
//	genId = 3000000l;
//	return genId;
	
	
	}
	
	
}


