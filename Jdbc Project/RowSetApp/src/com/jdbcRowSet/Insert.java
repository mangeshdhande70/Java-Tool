package com.jdbcRowSet;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Insert {
	

	public static void main(String[] args) throws SQLException {
		
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		
		JdbcRowSet jdbcRowset = rowSetFactory.createJdbcRowSet();// Same as ResultSet(Connected), but it is scrollable and Updatable.
		
		
		//Setting url ,username , pass
		jdbcRowset.setUrl("jdbc:mysql:///college");
		jdbcRowset.setUsername("root");
		jdbcRowset.setPassword("Md7$#1998");
		
		
		jdbcRowset.setCommand("SELECT * FROM student");
		jdbcRowset.execute();
		
		
		jdbcRowset.moveToInsertRow();
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				
				System.out.println("Enter the Name");
				String name = scanner.next();
				
				System.out.println("Enter the Age");
				int age = scanner.nextInt();
				
				System.out.println("Enter the address");
				String address = scanner.next();
				
				
			    jdbcRowset.updateString(2, name);
			    jdbcRowset.updateInt(3, age);
			    jdbcRowset.updateString(4, address);
			    
			    jdbcRowset.insertRow();
			    
			    
			    System.out.println("Record Inserted Successfully");
			    
			    System.out.println("Do you want to insert one more record [YES/NO] ");
			    
			    String option = scanner.next();
			    
			    if (option.equalsIgnoreCase("No")) {
			    	System.out.println("Thank You....Check your Database");
			    	break;
				}
			   	
			}
			
			scanner.close();
			jdbcRowset.close();
		}
	
	}
	
	

}
