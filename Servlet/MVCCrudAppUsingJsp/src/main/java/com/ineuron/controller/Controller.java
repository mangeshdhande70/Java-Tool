package com.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ineuron.dto.StudentDTO;
import com.ineuron.factory.ServiceStudentFactory;
import com.ineuron.service.IServiceStudent;

@WebServlet(urlPatterns = "/controller/*")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IServiceStudent iServiceStudent = ServiceStudentFactory.getService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try {
			doProcess(request, response);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			doProcess(request, response);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {

		PrintWriter out = response.getWriter();

		if (request.getRequestURI().endsWith("addform")) {
			String name = request.getParameter("sname");
			int age = Integer.parseInt(request.getParameter("sage"));
			String address = request.getParameter("saddr");

			try {
				String msg = iServiceStudent.addStudent(name, age, address);

				RequestDispatcher requestDispatcher = null;
				
				if (msg.equalsIgnoreCase("success")) {
					requestDispatcher = request.getRequestDispatcher("../success.html");
					requestDispatcher.forward(request, response);
				} else if (msg.equalsIgnoreCase("failed")) {
					requestDispatcher = request.getRequestDispatcher("../failed.html");
					requestDispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (request.getRequestURI().endsWith("deleteform")) {

			int id = Integer.parseInt(request.getParameter("sid"));

			if (iServiceStudent.searchStudentById(id) != null) {

				String msg = iServiceStudent.deleteStudent(id);
				
				System.out.println(request.getRequestURI());
				System.out.println(request.getPathInfo());
				
				RequestDispatcher requestDispatcher = null;
				if (msg.equalsIgnoreCase("success")) {

					requestDispatcher =	request.getRequestDispatcher("../deletesuccess.html");	
					try {
						requestDispatcher.forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (msg.equalsIgnoreCase("failed")) {
				  requestDispatcher = request.getRequestDispatcher("../deletefailed.html");	
				  try {
					requestDispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					

				} else {
				requestDispatcher = request.getRequestDispatcher("../recordnotfound.html");	
				try {
					requestDispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				}

			}

		}

		if (request.getRequestURI().endsWith("searchform")) {

			int id = Integer.parseInt(request.getParameter("sid"));

		    StudentDTO studentDTO = iServiceStudent.searchStudentById(id);
		
			request.setAttribute("student", studentDTO);
			RequestDispatcher requestDispatcher = null;
			requestDispatcher = request.getRequestDispatcher("../display.jsp");
			requestDispatcher.forward(request, response);

				

		}

		if (request.getRequestURI().endsWith("editform")) {

			int id = Integer.parseInt(request.getParameter("sid"));

			StudentDTO student = iServiceStudent.searchStudentById(id);

			if (student != null) {
				out.println("<body>");
				out.println("<center>");
				out.println("<form method='post' action='./controller/updateRecord'>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>" + student.getId() + "</td></tr>");
				out.println("<input type='hidden' name='sid' value='" + student.getId() + "'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + student.getSname()
						+ "'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='" + student.getSage()
						+ "'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddr' value='" + student.getSaddress()
						+ "'/></td></tr>");
				out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");

			}else {
				out.println("<h1>Student not exit for given id::"+id+"</h1>");
			}

		}

		if (request.getRequestURI().endsWith("updateRecord")) {

			int id =Integer.parseInt(request.getParameter("sid"));
			String name = request.getParameter("sname");
			int age =Integer.parseInt(request.getParameter("sage"));
			String address = request.getParameter("saddr");
			
			String msg = iServiceStudent.updateStudent(id,name,age,address);

			RequestDispatcher requestDispatcher = null;
			
			if (msg.equalsIgnoreCase("success")) {
				
				requestDispatcher =	request.getRequestDispatcher("../../updatesuccess.html");
				try {
					requestDispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}else {
				requestDispatcher =request.getRequestDispatcher("../../updatefailed.html");
				try {
					requestDispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}

	}

}