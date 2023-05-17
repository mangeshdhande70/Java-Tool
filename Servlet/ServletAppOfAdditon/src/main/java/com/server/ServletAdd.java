package com.server;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/add")
public class ServletAdd extends HttpServlet{

	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException { // only For Get request
		
		
		
		int num1 =Integer.parseInt(request.getParameter("num1"));
		int num2 =Integer.parseInt(request.getParameter("num2"));
		
		int ans = num1+num2;
		
//	   PrintWriter out = response.getWriter();
	   
//	   printWriter.println("Answer = "+ans);
		
		
	   
	   
	   
	   // using dispatcher client didn't have any idea which servlet is called
//	   RequestDispatcher dispatcher = request.getRequestDispatcher("multi");
//	   dispatcher.forward(request, response);
	   
	   
	   // U can Directly pass this 
//	   response.sendRedirect("multi?ans="+ans);
	   
	   HttpSession session = request.getSession();
	   
	   session.setAttribute("ans", ans);
	   
	   response.sendRedirect("multi");
		
	}
	


}
