package com.ineuron.service;

import java.io.IOException;
import java.sql.SQLException;

import com.ineuron.dto.StudentDTO;

public interface IServiceStudent {

	public String addStudent(String name, int age, String address) throws SQLException;

	public StudentDTO searchStudentById(int id) throws SQLException, IOException;

	public String updateStudent(int id , String name,int age,String address) throws SQLException;

	public String deleteStudent(int id);

}
