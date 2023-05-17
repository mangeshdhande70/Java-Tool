package com.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
		
	    out.println("<h1> Request URI :: "+request.getRequestURI()+"</h1>");
	    out.println("<h1> Context Path :: "+request.getContextPath()+"</h1>");
	    out.println("<h1> Servlet Path :: "+request.getServletPath()+"</h1>");
	    out.println("<h1> IP Address :: "+request.getRemoteHost()+"</h1>");
	    out.println("<h1> PORT :: "+request.getRemotePort()+"</h1>");
	    out.println("<h1> Query String :: "+request.getQueryString()+"</h1>");
		
		
	    out.close();
		
		
		
		
	}

	
}
