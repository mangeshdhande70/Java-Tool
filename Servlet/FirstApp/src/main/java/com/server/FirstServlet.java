package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/hello")
public class FirstServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
//		"color:blue;"
		PrintWriter out = res.getWriter();
		
		out.println("<h1 style='color:red; background-color:#808080'>Hello World<h1>");
		
		out.println("<button style='color:red;'>Submit</button>");
		out.println("<p>Hey I am <mark>Mangesh</mark></p>");
		
		
		
		out.println("<form action=\"\" method=\"get\" class=\"form-example\">\r\n"
				+ "  <div class=\"form-example\">\r\n"
				+ "    <label for=\"name\">Enter your name: </label>\r\n"
				+ "    <input type=\"text\" name=\"name\" id=\"name\" required>\r\n"
				+ "  </div>\r\n"
				+ "  <div class=\"form-example\">\r\n"
				+ "    <label for=\"email\">Enter your email: </label>\r\n"
				+ "    <input type=\"email\" name=\"email\" id=\"email\" required>\r\n"
				+ "  </div>\r\n"
				+ "  <div class=\"form-example\">\r\n"
				+ "    <input type=\"submit\" value=\"Subscribe!\">\r\n"
				+ "  </div>\r\n"
				+ "</form>\r\n"
				+ "");
	
		
		out.println("<form action=\"\" method='get' class='form-example'>\r\n"
				    +"<label for='name'> Enter your name: </label>\r\n"
				    +" <input type=\"text\" name=\"name\" id=\"name\" required>\r\n");
		
		
		
		out.println("<iframe width=\"660\" height=\"371\" src=\"https://www.youtube.com/embed/I7LrS1z_WNA?list=PLu71SKxNbfoDBNF5s-WH6aLbthSEIMhMI\" title=\"Class ID and iframe | HTML in Hindi\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe> ");               
		
		out.println("<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d238129.60362826305!2d78.93242040006622!3d21.161348398502543!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bd4c0a5a31faf13%3A0x19b37d06d0bb3e2b!2sNagpur%2C%20Maharashtra!5e0!3m2!1sen!2sin!4v1669492595271!5m2!1sen!2sin\" width=\"600\" height=\"450\" style=\"border:0;\"  loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>");
	    
		out.close();
		
	}

}
