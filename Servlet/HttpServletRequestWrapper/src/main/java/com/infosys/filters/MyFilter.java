package com.infosys.filters;

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
import javax.servlet.http.HttpServletRequest;

import com.infosy.custom.MyCustomeClass;

@WebFilter("/reg")
public class MyFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		MyCustomeClass customReq = new MyCustomeClass(httpServletRequest);

//		System.out.println("inside filter id :: "+id);

		chain.doFilter(customReq, response);
		
		PrintWriter out = response.getWriter();
		
		String parameter = request.getParameter("id");
		
		out.println("<h1> Response </h1>");
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
