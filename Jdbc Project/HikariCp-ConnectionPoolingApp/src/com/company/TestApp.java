package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class TestApp {
	
	// same program is executed in Intelije
	
	 public static void main(String[] args) throws SQLException {
		
		 
		 String configFile = "src\\com\\company\\application.properties";
		 
	    HikariConfig config = new HikariConfig(configFile);
		
//		String configFile1 = "src\\in\\ineuron\\main\\db.properties";
//		HikariConfig config2 = new HikariConfig(configFile);

		
		
		try (HikariDataSource dataSource = new HikariDataSource(config)) {

			Connection connection = dataSource.getConnection();
			
		   PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");
		   ResultSet resultSet = preparedStatement.executeQuery();
			
		   System.out.println("Id\tStudent Name\t\tAGE\t\tAddress");
		   while (resultSet.next()){
	            System.out.println(resultSet.getInt(1)+"\t   "+resultSet.getString(2)+"\t\t\t"+
	                        resultSet.getInt(3)+"\t\t"+resultSet.getString(4));
	            }
		   
		  dataSource.close();

		   
		}
		
	 
	 }

}
