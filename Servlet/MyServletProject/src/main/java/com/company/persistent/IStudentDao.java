package com.company.persistent;

import java.sql.SQLException;
import java.util.ArrayList;

import com.company.studentDto.StudentDto;

public interface IStudentDao {
	
	public ArrayList<StudentDto> getAllStudent() throws SQLException;

}
