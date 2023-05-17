package com.emp.db;

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
	
	
	public static Connection jdbConnection() throws SQLException {
		
		
		String path = "D:\\Spring All\\Eclipse\\Servlet\\EmployeeFilterApp\\src\\main\\java\\com\\emp\\db\\application.properties";
		
		HikariConfig config = new HikariConfig(path);
		
		@SuppressWarnings("resource")
		HikariDataSource dataSource = new HikariDataSource(config);
		
		return dataSource.getConnection();
		
		
	}

}
