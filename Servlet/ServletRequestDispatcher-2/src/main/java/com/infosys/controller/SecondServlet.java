package com.infosys.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Controll in Servlet 2");

		PrintWriter out = response.getWriter();

		out.println("<h1>Servlet 2</h1>");
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./welcome.jsp");
		requestDispatcher.forward(request, response);
	}

}
