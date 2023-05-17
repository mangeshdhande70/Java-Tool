package com.emp.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.emp.db.JDBCConnection;

@WebFilter("/login")
public class LoginFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String query = "SELECT * FROM emp WHERE id=?";

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		System.out.println(pass);

		PrintWriter out = response.getWriter();

		try {
			connection = JDBCConnection.jdbConnection();

			if (connection != null)
				preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				if (resultSet.getString(1).equals(id) && resultSet.getString(6).equals(pass)) {
					chain.doFilter(request, response);
				} else {
					out.println("<h1> Pass Wrong ....</h1>");
				}

			} else {
				out.println("<h1> Employee Not Reg with this ID...please check once <h1>");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void destroy() {

		try {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
