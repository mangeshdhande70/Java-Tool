package com.hibernate.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class StudentDTO {

		private Integer studentId;
		private String studentName;
		private String branch;
		private List<String> projects;
		private Set<Long> contactNo;
		private Map<String, Float> cgpa;

		

}
