package com.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletConfigApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		 ServletContext context = getServletContext();
		 
		 String url =  context.getInitParameter("jdbcUrl");
		 String username = context.getInitParameter("user");
		 String pass = context.getInitParameter("password");
		 
		 
		 
		 PrintWriter out = response.getWriter();
		 
		 out.println("<body>");
		 out.println("<h1>SERVLET CONTEXT </h1>");
		 
		 out.println("<table border='1'>");
		 out.print("<tr><th>URL</th><th>Username</th><th>Password</th></tr>");
		 
		 out.println("<tr>");
		 out.println("<td>"+url+"</td>");
		 out.println("<td>"+username+"</td>");
		 out.println("<td>"+pass+"</td>");
		 out.println("</tr>");
		 
		
		

	}

	
}
