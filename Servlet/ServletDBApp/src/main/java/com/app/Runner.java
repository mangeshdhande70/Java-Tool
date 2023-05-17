package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Runner extends HttpServlet {
	
	
	Connection connection = null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class Loaded Successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void init(){
		
		
		String url = getInitParameter("url");
		String username = getInitParameter("username");
		String password = getInitParameter("password");
		
		try {
			connection = DriverManager.getConnection(url,username,password);
			if (connection != null) {
				System.out.println("Connection Established ..............");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<body>");
		out.println("<h1>DATA</h1>");
		
		out.println("<table>");
		
		out.println("<tr> <th>ID </th> </tr>"
				+ "<tr> <th> Name </th> </tr>");
		
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		
		try {
			preparedStatement = connection.prepareStatement("SELECT sid,sname FROM student");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				out.println("<td>"+resultSet.getInt(1)+"</td>");
				out.println("<td>"+resultSet.getString(2)+"</td>");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		
		
		out.println("</table>");
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
