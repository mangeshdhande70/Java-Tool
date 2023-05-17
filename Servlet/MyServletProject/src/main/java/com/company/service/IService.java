package com.company.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.company.studentDto.StudentDto;

public interface IService {
	
	public ArrayList<StudentDto> getAllSetudent() throws SQLException;
	

}
