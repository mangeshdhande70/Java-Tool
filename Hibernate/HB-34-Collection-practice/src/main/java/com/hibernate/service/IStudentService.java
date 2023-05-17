package com.hibernate.service;

import com.hibernate.dto.StudentDTO;

public interface IStudentService {
	
	
	public Integer addStudent(StudentDTO studentDTO);
	
	public StudentDTO findStudentById(Integer id);
	
	

}
