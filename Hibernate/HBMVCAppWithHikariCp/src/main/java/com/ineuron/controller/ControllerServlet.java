package com.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ineuron.factory.StudentServiceFactory;
import com.ineuron.model.Student;
import com.ineuron.util.HibernateUtil;
import com.ineuronservice.IStudentService;

@WebServlet(urlPatterns = { "/controller/*" }, loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {

	static {
		HibernateUtil.startUp();
	}
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IStudentService stdService = StudentServiceFactory.getStudentService();

		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("addform")) {

			String sage = request.getParameter("sage");
			String sname = request.getParameter("sname");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddress(saddr);

			String status = stdService.addStudent(student);
			RequestDispatcher rd = null;

			request.setAttribute("status", status);
			rd = request.getRequestDispatcher("../insertResult.jsp");
			rd.forward(request, response);

		}

		if (request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");
			Student student = stdService.searchStudent(Integer.parseInt(sid));
			request.setAttribute("student", student);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../display.jsp");
			rd.forward(request, response);
		}

		if (request.getRequestURI().endsWith("deleteform")) {
			String sid = request.getParameter("sid");
			String status = stdService.deleteStudent(Integer.parseInt(sid));
			RequestDispatcher rd = null;

			request.setAttribute("status", status);
			rd = request.getRequestDispatcher("../deleteResult.jsp");
			rd.forward(request, response);

		}
		if (request.getRequestURI().endsWith("editform")) {
			String sid = request.getParameter("sid");

			Student student = stdService.searchStudent(Integer.parseInt(sid));
			RequestDispatcher rd = null;
			if (student != null) {
				request.setAttribute("student", student);
				rd = request.getRequestDispatcher("../updateForm.jsp");
				rd.forward(request, response);
			}else {
			String status = "Not found";
				System.out.println("return Not Found from else ");
				request.setAttribute("status", status);
				rd = request.getRequestDispatcher("../update.jsp");
				rd.forward(request, response);
			}
		}
		if (request.getRequestURI().endsWith("updateRecord")) {
			int sid =Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setId(sid);
			student.setSaddress(saddr);
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));

			String status = stdService.updateStudent(student);
			RequestDispatcher rd = null;

			request.setAttribute("status", status);
			rd = request.getRequestDispatcher("../../update.jsp");
			rd.forward(request, response);

		}
	}
}
