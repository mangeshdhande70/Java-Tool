package com.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/reg" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql:///college"), 
				@WebInitParam(name = "username", value = "root"), 
				@WebInitParam(name = "password", value = "Md7$#1998")
		})
public class ServletConfigAnnotationApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	Connection connection = null;
	
	
	static {
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init() {
		
		ServletConfig servletConfig = getServletConfig();
		String url = servletConfig.getInitParameter("url");
		String username = servletConfig.getInitParameter("username");
		String password = servletConfig.getInitParameter("password");
		
//		
//		  String url = getInitParameter("url"); 
//		  String username =getInitParameter("username"); 
//		  String password = getInitParameter("password");
		 
		
		try {
			connection  = DriverManager.getConnection(url,username,password);
			System.out.println("Connection established.........");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			preparedStatement = connection.prepareStatement("SELECT email FROM registration");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String email    = request.getParameter("email");
		String password = request.getParameter("new password");
		String aPassword = request.getParameter("aPassword");
	
		
		
		PreparedStatement preparedStatement = null;
		
		try {
			
			if (password.equals(aPassword)) {
				preparedStatement = connection.prepareStatement("INSERT INTO registration(username,email,password) values(?,?,?)");
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, password);
				
				
				int rowAffected = preparedStatement.executeUpdate();
				
				if (rowAffected!=0) {
					
					out.println("Registerd Seccessfully");	
					
				}
				
			}else {
				   out.println("Password not matched ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("User Already Registerd with this email.....");
		}
		
//		out.close();
		
		
	}
	
	@Override
	public void destroy() {
		
			try {
				if (connection!=null) 
							connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


	
}
