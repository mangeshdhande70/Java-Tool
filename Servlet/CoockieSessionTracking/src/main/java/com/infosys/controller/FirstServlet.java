package com.infosys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("pname");
		String cost = request.getParameter("pcost");
       
		HttpSession session = request.getSession();
		
		session.setAttribute("pname", name);
		session.setAttribute("pcost", cost);
		
		Cookie c1 = new Cookie("name", name);
		Cookie c2 = new Cookie("cost", cost);
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("form2.html");
		requestDispatcher.forward(request, response);
		
	}

	

}
