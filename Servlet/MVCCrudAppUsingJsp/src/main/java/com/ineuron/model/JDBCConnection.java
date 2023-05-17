package com.ineuron.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public abstract class JDBCConnection {

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getJdbConnectionByPhysical() throws SQLException, IOException {

		String configFile = "D:\\Spring All\\Eclipse\\Servlet\\JDBCCrudApp\\src\\main\\java\\com\\ineuron\\jdbc\\application.properties";

		File file = new File(configFile);

		FileInputStream fisFileInputStream = new FileInputStream(file);

		Properties properties = new Properties();
		properties.load(fisFileInputStream);

		String url = properties.getProperty("jdbcUrl");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		return DriverManager.getConnection(url, username, password);

	}

	public static Connection jdbcConnectionByHikariCP() throws SQLException {

		String configFile = "C:\\Users\\mangesh.dhande\\git\\repository9\\JDBCCrudApp\\src\\main\\java\\com\\ineuron\\model\\application.properties";
		HikariConfig config = new HikariConfig(configFile);

		@SuppressWarnings("resource")
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource.getConnection();

	}

}
