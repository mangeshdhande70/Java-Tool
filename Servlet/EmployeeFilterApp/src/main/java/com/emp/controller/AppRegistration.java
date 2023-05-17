package com.emp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.db.JDBCConnection;

@WebServlet("/reg")
public class AppRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String msg = "";
		String query = "INSERT INTO emp(`id`,`name`,`age`,`email`,`mob`,`pass`) VALUES (?,?,?,?,?,?) ";

		String id = request.getParameter("eid");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String mob = request.getParameter("mob");
		String pass = request.getParameter("pass");

		System.out.println("Servlet Call");

		try {
			connection = JDBCConnection.jdbConnection();

			if (connection != null) {

				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setInt(3, age);
				preparedStatement.setString(4, email);
				preparedStatement.setString(5, mob);
				preparedStatement.setString(6, pass);

				int rowAffected = preparedStatement.executeUpdate();

				if (rowAffected == 1)
					msg += "succes";
				else
					msg += "failed";

				System.out.println(msg);
				

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
