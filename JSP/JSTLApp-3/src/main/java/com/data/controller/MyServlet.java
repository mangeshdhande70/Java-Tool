package com.data.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 List<String> list = new ArrayList<String>();
		 
		 list.add("Mangesh");
		 list.add("Ankit");
		 list.add("Rakesh");
		 list.add("Dhiraj");
		 list.add("Vivek");
		 list.add("Amit");
		 
		 request.setAttribute("names", list);
		 
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("./display.jsp");
		 requestDispatcher.forward(request, response);
	
	
	
	}

}
