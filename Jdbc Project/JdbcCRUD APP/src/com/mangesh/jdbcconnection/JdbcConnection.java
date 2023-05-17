package com.mangesh.jdbcconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public abstract class JdbcConnection {
	

	public static Connection getJdbcConnection() throws SQLException, IOException {
	
		Connection connection = null;
		
		
		FileInputStream fileInputStream = new FileInputStream("D:\\Spring All\\Eclipse\\Jdbc Project\\JdbcCRUD APP\\src\\com\\mangesh\\properties\\application.properties");
		
		
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		
		
		connection = DriverManager.getConnection(properties.getProperty("url"),
												properties.getProperty("user"),
												properties.getProperty("password"));
		
		
		
		return connection;
	}
	
	
	public static void cleanUpResources(Connection connection ,Statement statement,ResultSet resultSet) throws SQLException  {
		
		
		
		if (resultSet!=null) 
			resultSet.close();
		
		if (statement!=null) 
			statement.close();
		
		if (connection!=null) 
			connection.close();
			
		
		
     }

}