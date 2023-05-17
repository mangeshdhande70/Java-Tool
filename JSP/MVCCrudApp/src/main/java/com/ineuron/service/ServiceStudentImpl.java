package com.ineuron.service;

import java.io.IOException;
import java.sql.SQLException;

import com.ineuron.dto.StudentDTO;
import com.ineuron.dtofactory.StudentDaoFactory;
import com.ineuron.persis.IStudentDao;

public class ServiceStudentImpl implements IServiceStudent {

	IStudentDao iStudentDao = StudentDaoFactory.getStudentDao();

	@Override
	public String addStudent(String name, int age, String address) throws SQLException {
		return iStudentDao.addStudent(name, age, address);
	}

	@Override
	public StudentDTO searchStudentById(int id) throws SQLException, IOException {
		return iStudentDao.searchStudentById(id);
	}

	@Override
	public String updateStudent(int id , String name,int age,String address) throws SQLException {
		return iStudentDao.updateStudent(id ,name, age,address);
	}

	@Override
	public String deleteStudent(int id) {
		return iStudentDao.deleteStudent(id);
	}

}
