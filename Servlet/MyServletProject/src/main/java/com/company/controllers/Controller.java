package com.company.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.IService;
import com.company.servicefactory.ServiceFactory;
import com.company.studentDto.StudentDto;


@WebServlet(urlPatterns = "/getAll")
public class Controller extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , HttpServletResponse response) {
		
		
		IService iService = ServiceFactory.getService();
		
		List<StudentDto> list = null;
		
		try {
		list = iService.getAllSetudent();
		
		
		PrintWriter out = response.getWriter();
		
		Iterator<StudentDto> iterator = list.iterator();
		
		
		out.println("ID"+"\t"+"Name"+"\t"+"Age"+"\t"+"Address"+"\t"+"Stipen");
		while(iterator.hasNext()) {
			
			StudentDto studentDto = iterator.next();
			
			out.println(studentDto.getId()+"\t"+studentDto.getName()+"\t"+studentDto.getAge()+
					"\t"+studentDto.getAddress()+"\t"+studentDto.getStipen());
			
		}
		
		out.close();
		
	    
		
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
