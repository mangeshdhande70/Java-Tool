package com.company.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.company.persistent.IStudentDao;
import com.company.studentDto.StudentDto;
import com.company.studentdaofactory.StudentDaoFactory;

public class ServiceImpl implements IService{

	@Override
	public ArrayList<StudentDto> getAllSetudent() throws SQLException {
		
		
		IStudentDao iStudentDao = StudentDaoFactory.getStudentDao();
		
		return iStudentDao.getAllStudent();
		
		
	}

}
