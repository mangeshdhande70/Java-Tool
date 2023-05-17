package com.hibernate.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hibernate.dto.StudentDTO;
import com.hibernate.service.IStudentService;
import com.hibernate.service.StudentServiceImpl;

public class Controller {

	private static IStudentService iStudentService = new StudentServiceImpl();

	public static void main(String[] args) {

//		StudentDTO studentDTO = new StudentDTO();
////		studentDTO.setStudentId(12345432);
//		studentDTO.setStudentName("Rakesh Pawar");
//		studentDTO.setBranch("Electrical");
//		studentDTO.setProjects(List.of("Electrical power", "Solar Panel", "Electricity through tree"));
//		studentDTO.setCgpa(Map.of("sem1", 8.98f, "sem2", 9.00f, "sem3", 8.99f));
//		studentDTO.setContactNo(Set.of(7897655439L, 999999988L));
//		
//		Integer id = iStudentService.addStudent(studentDTO);
//		
//		if (id != null) 
//			System.out.println("Student Information added successfully");
//		else 
//		    System.out.println("Student Informaation not added successfully");
		
		
		
//		System.out.println("\n\n");
//		
		int id2 = 1;
		StudentDTO studentDTO2 = iStudentService.findStudentById(id2);
		
		if (studentDTO2!=null) 
			System.out.println(studentDTO2);
	    else 
		     System.out.println("Student not found for given id :: "+id2);
		
	}

}
