package com.hibernate.customeGen;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyCustomeIdGen implements IdentifierGenerator {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Integer genId = null;

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		connection = session.connection();
		String sqlQuery = "SELECT id FROM StudentGenerator_3";
		Integer id = null;
		
//	Integer id1	=  ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
//
//	System.out.println("id = "+id1);
//	
	
   	try {
			if (connection != null)
				preparedStatement = connection.prepareStatement(sqlQuery);

			if (preparedStatement != null)
				resultSet = preparedStatement.executeQuery();

			
			while(resultSet.next()) {
				id =resultSet.getInt(1);
				genId = id + 1;
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return genId;
	}

}
