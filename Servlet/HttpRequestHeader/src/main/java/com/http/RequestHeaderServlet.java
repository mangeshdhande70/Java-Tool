package com.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/httpReq")
public class RequestHeaderServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:red; text-align:center;'>REQUEST HEADER INFORMATION...</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");

		Enumeration<String> hEnumeration = request.getHeaderNames();
		
		while (hEnumeration.hasMoreElements()) {
			out.println("<tr>");
			String headerName = (String) hEnumeration.nextElement();
			String value = request.getHeader(headerName);
			
			
			out.println("<td>"+headerName+"</td>");
			out.println("<td>"+value+"</td>");
			
			
			out.println("</tr>");
			
			
			
			
		}
		
		
		
		
		
		
		
	}

}
