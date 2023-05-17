package com.infosys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String brand = request.getParameter("pbrand");
		String quantity = request.getParameter("pquantity");
		
		
		Cookie c3 = new Cookie("brand", brand);
		Cookie c4 = new Cookie("pquantity", quantity);
		
		response.addCookie(c3);
		response.addCookie(c4);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("form3.html");
		requestDispatcher.forward(request, response);
		
		
		
	}

}
