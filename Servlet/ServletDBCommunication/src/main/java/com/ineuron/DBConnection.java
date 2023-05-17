package com.ineuron;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DBConnection extends HttpServlet {

	Connection connection = null;

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded Successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void init() throws ServletException {
		System.out.println("Config object created and got the values from config object...\n\n");

		String url = getInitParameter("url");
		String username = getInitParameter("username");
		String password = getInitParameter("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);

		try {
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("Connection established succesfully....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();

		out.println("<h1> Request Type :: " + request.getMethod() + "</h1>");

		String sql = "SELECT sid,sname,sage FROM student";

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

//				System.out.println(resultSet.getInt(1));
				out.println(resultSet.getInt(1));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
