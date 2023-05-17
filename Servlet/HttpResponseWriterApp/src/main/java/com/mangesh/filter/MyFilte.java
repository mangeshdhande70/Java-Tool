package com.mangesh.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mangesh.customeResp.Custom;

@WebFilter("/test")
public class MyFilte extends HttpFilter implements Filter {
       
 
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		chain.doFilter(request, response);
		
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		Custom custom = new Custom(httpServletResponse);
		
		
//		ServletConfig config = fConfig
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
