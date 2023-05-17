package com.rowset;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class TestApp {
	
	
	public static void main(String[] args) throws SQLException {
		
		
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		
		// Connection 
		JdbcRowSet jdbcRowSet = rowSetFactory.createJdbcRowSet();
		
		
		// Disconnection
		CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
		WebRowSet webRowSet = rowSetFactory.createWebRowSet();
		JoinRowSet joinRowSet = rowSetFactory.createJoinRowSet();
		FilteredRowSet filteredRowSet = rowSetFactory.createFilteredRowSet();
		
		
		
		System.out.println(jdbcRowSet.getClass().getName());
		System.out.println(cachedRowSet.getClass().getName());
		System.out.println(webRowSet.getClass().getName());
		System.out.println(joinRowSet.getClass().getName());
		System.out.println(filteredRowSet.getClass().getName());
			
		
		
		
		
		
		
	}
	

}
