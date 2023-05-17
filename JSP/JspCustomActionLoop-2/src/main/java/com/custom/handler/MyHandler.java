package com.custom.handler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class MyHandler implements IterationTag {

	private int count = 0;
	
	
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		System.out.println("MyHandler.setCount()");
		this.count = count;
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("MyHandler.doEndTag()");
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("MyHandler.doStartTag()");
		
		if (count>0) 
	    	return EVAL_BODY_AGAIN;
		
		return SKIP_BODY;
	}

	@Override
	public Tag getParent() {
		return null;
	}

	@Override
	public void release() {
		System.out.println("MyHandler.release()");
		
	}

	@Override
	public void setPageContext(PageContext arg0) {
		System.out.println("MyHandler.setPageContext()");
		
	}

	@Override
	public void setParent(Tag arg0) {
		System.out.println("MyHandler.setParent()");
		
	}

	@Override
	public int doAfterBody() throws JspException {
		System.out.println("MyHandler.doAfterBody()");
		if (--count>0)
			return EVAL_BODY_AGAIN;
		return SKIP_BODY;
	}

	
}
