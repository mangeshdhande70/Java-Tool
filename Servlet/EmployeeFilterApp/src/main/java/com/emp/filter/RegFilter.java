package com.emp.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/reg")
public class RegFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filteratipon...........");
		
		PrintWriter out = response.getWriter();
		Integer age = null;
		

		String id = request.getParameter("eid");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		
		if (!request.getParameter("age").isEmpty()) {
			try {
			age = Integer.parseInt(request.getParameter("age"));	
			}catch (NumberFormatException e) {
				out.println("please enter age in Integer value");
				return;
			}
		}else {
			out.println("age should not be empty");
			return;
		}
		
//
//		if(id.isEmpty()) {
//			out.println("<h1> Id should not be empty</h1>");
//			return;
//		}
//		
//		if(email.isEmpty()) {
//			out.println("<h1> Email should not be empty</h1>");
//			return;
//		}
//		
//		if(pass.isEmpty()) {
//			out.println("<h1> Password should not be empty</h1>");
//			return;
//		}
		
	

		if (id.startsWith("iNeuron-") && (age > 20 || age < 30) && email.endsWith("@ineuron.ai") && pass.length() > 8) {

			chain.doFilter(request, response);

			out.println("<h1 style='color:grren;'>Suucessfully Added.........</h1>");

		} else {

			out.println("<h1> Please provide correct details</h1>");

		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
