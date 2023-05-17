package com.param.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class ParamServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		
		out.println(name);
		
		
		String salary = request.getParameter("salary");
		
		out.println(salary);
		
	}

}
