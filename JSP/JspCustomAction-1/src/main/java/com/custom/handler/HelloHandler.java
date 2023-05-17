package com.custom.handler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloHandler implements Tag {

	PageContext pageContext;
	private String name;

	public HelloHandler(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	static {
		System.out.println("HelloHandler.class file is loading...");
	}

	public HelloHandler() {
		System.out.println("HelloHanlder object is instantiated...");
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		System.out.println("HelloHandler.setPageContext()");
	}

	@Override
	public void setParent(Tag arg0) {
		System.out.println("HelloHandler.setParent()");
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("HelloHandler.doStartTag()");

		try {
			JspWriter out = pageContext.getOut();
			out.println("<h1>Hello This is from the Tag Hanlder class</h1>");
			out.println("<h1>Hello " + name + "...Good Evening <h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public Tag getParent() {
		System.out.println("HelloHandler.getParent()");
		return null;
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("HelloHandler.doEndTag()");
		return SKIP_PAGE;
	}

	@Override
	public void release() {
		System.out.println("HelloHandler.release()");
	}

}
