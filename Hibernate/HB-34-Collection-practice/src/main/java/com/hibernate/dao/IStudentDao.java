package com.hibernate.dao;

import com.hibernate.model.StudentInfoGEC;

public interface IStudentDao {
	
    public Integer addStudent(StudentInfoGEC student);
	
	public StudentInfoGEC findStudentById(Integer id);
	

}
