package com.company.persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.company.studentDto.StudentDto;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class StudentDao implements IStudentDao {

	
	@Override
	public ArrayList<StudentDto> getAllStudent()  {

		String fileString = "D:\\Spring All\\Eclipse\\Servlet\\MyServletProject\\src\\main\\java\\application.properties";

		HikariConfig config = new HikariConfig(fileString);
	
		ArrayList<StudentDto> arrayList = new ArrayList<>();
		StudentDto studentDto = null;
		
		
		try (HikariDataSource dataSource = new HikariDataSource(config)) {

			Connection connection = dataSource.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");

			ResultSet resultSet = preparedStatement.executeQuery();

			
//			 System.out.println("Id\tStudent Name\t\tAGE\t\tAddress");
//			   while (resultSet.next()){
//		            System.out.println(resultSet.getInt(1)+"\t   "+resultSet.getString(2)+"\t\t\t"+
//		                        resultSet.getInt(3)+"\t\t"+resultSet.getString(4));
//		            }
			
			
//			studentDto = new StudentDto();
//			arrayList = new ArrayList<>();
//			
//			studentDto.setId(1);
//			studentDto.setName("mangesh");
//			studentDto.setAddress("Nirli");
//			studentDto.setAge(22);
//			studentDto.setStipen(3000);
//			
//			arrayList.add(studentDto);
			
//			
////		   System.out.println("Id\tStudent Name\t\tAGE\t\tAddress");
			while (resultSet.next()) {
				
	
				studentDto = new StudentDto();

				studentDto.setId(resultSet.getInt(1));
				studentDto.setName(resultSet.getString(2));
				studentDto.setAge(resultSet.getInt(3));
				studentDto.setStipen(resultSet.getInt(4));

				arrayList.add(studentDto);

			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	
	}

}
