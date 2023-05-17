package com.jdbcRowSet;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Update {

	

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
			
			int actualStipen = jdbcRowset.getInt(5);
			if (actualStipen < 1000) {
				
				int updateStipen = actualStipen+1000;
				
				jdbcRowset.updateInt(5, updateStipen);
				jdbcRowset.updateRow();
				
			}
			
		}
		
		System.out.println("Record Update Successfully");
			jdbcRowset.close();
		}
	
	
}
