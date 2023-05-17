package com.server.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/multi")
public class ServletSq extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//		int ans =Integer.parseInt(request.getParameter("ans"));
		
		
		HttpSession session = request.getSession();
		
		int ans = (int) session.getAttribute("ans");

		ans = ans * ans;

		PrintWriter out = response.getWriter();

		out.println(ans);

//		System.out.println("Multi");

	}

}
