package com.ineuron.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ImplementationClassName")
public class ImplementationClassName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       ServletConfig config = getServletConfig();
       ServletContext context = getServletContext();
	  
	  System.out.println("Implementation Classess Name :: ");
	  System.out.println("Implementation class name of config is :: "+config.getClass().getName());
	  System.out.println("Implementation class name of context is :: "+context.getClass().getName());
	  System.out.println("Implementation class name of request is :: "+request.getClass().getName());
	  System.out.println("Implementation class name of response is :: "+response.getClass().getName());
	  
	  
	  
	}

	
}
