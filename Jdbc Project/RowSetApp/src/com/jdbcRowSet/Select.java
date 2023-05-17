package com.jdbcRowSet;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Select {
	
	
	public static void main(String[] args) throws SQLException {
		
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		
		JdbcRowSet jdbcRowset = rowSetFactory.createJdbcRowSet();// Same as ResultSet(Connected), but it is scrollable and Updatable.
		
		
		//Setting url ,username , pass
		jdbcRowset.setUrl("jdbc:mysql:///college");
		jdbcRowset.setUsername("root");
		jdbcRowset.setPassword("Md7$#1998");
		
		
		jdbcRowset.setCommand("SELECT * FROM student");
		jdbcRowset.execute();
		
		 
		System.out.println("\nRetriving Data in Normal Manner..........\n");
		  System.out.println("Id\tStudent Name\t\tAGE\t\tAddress");
          while (jdbcRowset.next()) {
              System.out.println(jdbcRowset.getInt(1) + "\t   " + jdbcRowset.getString(2) + "\t\t" +
            		  jdbcRowset.getInt(3) + "\t\t" + jdbcRowset.getString(4));
          }
		
		
          System.out.println("\n\n______________________________________________________________________________________\n\n");
          
          
      	System.out.println("Retriving Data in Reverse Manner..........\n");
		  System.out.println("Id\tStudent Name\t\tAGE\t\tAddress");
        while (jdbcRowset.previous()) {
            System.out.println(jdbcRowset.getInt(1) + "\t   " + jdbcRowset.getString(2) + "\t\t" +
          		  jdbcRowset.getInt(3) + "\t\t" + jdbcRowset.getString(4));
        }
		
	
        System.out.println("\n\n______________________________________________________________________________________\n\n");
        
		
        // accessing the record randomly
        jdbcRowset.absolute(4); //starting from 1
        System.out.println(jdbcRowset.getInt(1) + "\t   " + jdbcRowset.getString(2) + "\t\t\t" +
        		  jdbcRowset.getInt(3) + "\t\t" + jdbcRowset.getString(4));
        
		
        System.out.println("\n\n______________________________________________________________________________________\n\n");
		
        
        jdbcRowset.relative(-2);//starting from cursor 
        System.out.println(jdbcRowset.getInt(1) + "\t   " + jdbcRowset.getString(2) + "\t" +
      		  jdbcRowset.getInt(3) + "\t" + jdbcRowset.getString(4));
        
	}
	
	

}
