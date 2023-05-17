package com.ineuron.controller;

import java.io.IOException;
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

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {


		if (request.getRequestURI().endsWith("addform")) {
			
			String name = request.getParameter("sname");
			int age = Integer.parseInt(request.getParameter("sage"));
			String address = request.getParameter("saddr");

			String status = iServiceStudent.addStudent(name, age, address);

			RequestDispatcher rd = null;

			if (status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../insetForm.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("status", "failure");
				rd = request.getRequestDispatcher("../insetForm.jsp");
				rd.forward(request, response);
			}

		}

		if (request.getRequestURI().endsWith("deleteform")) {

			int id = Integer.parseInt(request.getParameter("sid"));
			String status = iServiceStudent.deleteStudent(id);
			RequestDispatcher rd = null;

			if (status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../delete.jsp");
				rd.forward(request, response);
			} else if (status.equals("failure")) {
				request.setAttribute("status", "failure");
				rd = request.getRequestDispatcher("../delete.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("status", "not found");
				rd = request.getRequestDispatcher("../delete.jsp");
				rd.forward(request, response);
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
			RequestDispatcher rDispatcher = null;

			StudentDTO student = iServiceStudent.searchStudentById(id);

			if (student != null) {
				request.setAttribute("student", student);
				rDispatcher = request.getRequestDispatcher("../updateForm.jsp");
				rDispatcher.forward(request, response);

			}
		}

		if (request.getRequestURI().endsWith("updateRecord")) {

			int id = Integer.parseInt(request.getParameter("sid"));
			String name = request.getParameter("sname");
			int age = Integer.parseInt(request.getParameter("sage"));
			String address = request.getParameter("saddr");

			String status = iServiceStudent.updateStudent(id, name, age, address);

			RequestDispatcher requestDispatcher = null;

			if (status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("../../updatesuccess.html");
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = request.getRequestDispatcher("../../updatefailure.html");
				requestDispatcher.forward(request, response);
			}

		}

	}

}