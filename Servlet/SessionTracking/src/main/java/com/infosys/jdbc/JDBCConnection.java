package com.infosys.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public abstract class JDBCConnection {
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static Connection getJdbConnection() throws SQLException {
		
		String path = "D:\\Spring All\\Eclipse\\Servlet\\SessionTracking\\src\\main\\java\\com\\infosys\\jdbc\\application.properties";
		
		HikariConfig config = new HikariConfig(path);
		
		@SuppressWarnings("resource")
		HikariDataSource dataSource = new HikariDataSource(config);
		
		return dataSource.getConnection();
		
		
		
	}
	

}
