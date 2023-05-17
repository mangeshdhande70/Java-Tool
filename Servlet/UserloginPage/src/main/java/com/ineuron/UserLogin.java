package com.ineuron;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/loginpage")
public class UserLogin extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
	   String uName = request.getParameter("Uname");
       String pass =	request.getParameter("Pass");
	
		PrintWriter out = response.getWriter();
		
		out.println("Successfully Log in........");
		out.println("Your Username :: "+uName);
		out.println("Your Pass :: "+pass);
		
		
		
	}
	
	
	

}
