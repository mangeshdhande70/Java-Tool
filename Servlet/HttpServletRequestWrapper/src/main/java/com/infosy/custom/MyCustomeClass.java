package com.infosy.custom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyCustomeClass extends HttpServletRequestWrapper {

	public MyCustomeClass(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {

		String appendedId = null;
		
		System.out.println(name);
		
		String id = super.getParameter("eid");

		if (!id.startsWith("iNeuron-")) {
			appendedId = "iNeuron- " + id;
		}

		return appendedId;

	}

}
