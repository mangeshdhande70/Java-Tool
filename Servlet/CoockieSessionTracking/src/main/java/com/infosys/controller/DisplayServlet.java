package com.infosys.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/disp")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    String pcatogory = request.getParameter("pcatogory");
	    String pmanufacturer = request.getParameter("pmanufacturer");
	
	   
	    
	    Cookie[] cookies = request.getCookies();
	    
	     String name = cookies[1].getValue();
	     String cost = cookies[2].getValue();
	     String brand = cookies[3].getValue();
	     String qty = cookies[4].getValue();
	    
	    
	    PrintWriter out = response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body bgcolor='lightgreen'>");
		out.println("<h1 style='color:red; text-align:center;'>Registration Details...</h1>");
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		out.println("<tr><td>PNAME</td>"+"<td>"+name+"</td>");
		out.println("<tr><td>COST</td>"+"<td>"+cost+"</td>");
		out.println("<tr><td>BRAND</td>"+"<td>"+brand+"</td>");
		out.println("<tr><td>QUANTITY</td>"+"<td>"+qty+"</td>");
		out.println("<tr><td>CATOGORY</td>"+"<td>"+pcatogory+"</td>");
		out.println("<tr><td>MANUFACTURER</td>"+"<td>"+pmanufacturer+"</td>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	
		out.close();

	
	
	}

}
