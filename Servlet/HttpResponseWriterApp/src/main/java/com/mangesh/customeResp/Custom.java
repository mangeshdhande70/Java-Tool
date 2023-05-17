package com.mangesh.customeResp;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


public class Custom extends HttpServletResponseWrapper {

	public Custom(HttpServletResponse response) {
		super(response);

	
	
	}
	

	@Override
    public void setContentType(String name) {
		
		
//		super.
		
		super.setContentType("pdf");
		
	}

}
