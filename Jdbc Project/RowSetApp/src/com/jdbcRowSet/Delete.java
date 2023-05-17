package com.jdbcRowSet;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Delete {

public static void main(String[] args) throws SQLException {
		
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		
		JdbcRowSet jdbcRowset = rowSetFactory.createJdbcRowSet();// Same as ResultSet(Connected), but it is scrollable and Updatable.
		
		
		//Setting url ,username , pass
		jdbcRowset.setUrl("jdbc:mysql:///college");
		jdbcRowset.setUsername("root");
		jdbcRowset.setPassword("Md7$#1998");
		
		
		jdbcRowset.setCommand("SELECT * FROM student");
		jdbcRowset.execute();
		
		
		
		while (jdbcRowset.next()) {
			
			String adress = jdbcRowset.getString(4);
			if (adress.equalsIgnoreCase("Nirli")) {
				
			   jdbcRowset.deleteRow();		}
			
		}
		
		System.out.println("Record Deleted Successfully");
			jdbcRowset.close();
		}
	
}
