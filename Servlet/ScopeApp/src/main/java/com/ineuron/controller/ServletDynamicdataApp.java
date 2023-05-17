package com.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletDynamicdataApp")
public class ServletDynamicdataApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		ServletContext context = getServletContext();
		
		context.setAttribute("name", "Mangesh");
	    context.setAttribute("age", 17); 
	    
	    PrintWriter out = response.getWriter();
	    
	    out.println("<body><h1>Http Dynamic Data </h1>");
	    out.println("<table border='1'>");
	    out.println("<table border='1'><tr><th>Attribute Name</th><th>Attribute Value</th></tr>");
	    
	    Enumeration<String> attributeNames = context.getAttributeNames();
	    
	    while (attributeNames.hasMoreElements()) {
			out.println("<tr>");
	    	String attributeName = (String) attributeNames.nextElement();
	    	Object attributeValue =  context.getAttribute(attributeName);
	    	out.print("<td>"+attributeName+"</td>");
	    	out.print("<td>"+attributeValue+"</td>");
			out.println("</tr>");
		}
	    out.println("</table></body>");

       
	
	}




}
