package com.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/httpReq")
public class RequestHeaderServlet extends HttpServlet {
	
	
	
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		File file = new File("D:\\Spring All\\Eclipse\\Servlet\\HttpResopnseImage\\photoM.jpg");
		
		FileInputStream  fis = new FileInputStream(file);
		
		byte[] b = new byte[(int)file.length()];
		
		fis.read(b);
		
		
	    ServletOutputStream outputStream =response.getOutputStream();
	    outputStream.write(b);
	    
	    outputStream.flush();
	    outputStream.close();
	    fis.close();
	
		
		}
		
}

