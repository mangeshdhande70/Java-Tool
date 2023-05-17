package com.hibernate.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;

@Entity
@Table(name = "Student_Info_GEC")
@Data
public class StudentInfoGEC {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "student_id")
	private Integer studentId;

	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "branch")
	private String branch;
	
	
	@ElementCollection
	@Column(name = "projects_name")
	@CollectionTable(name = "STUDENT_PROJECT_LIST" ,joinColumns =  @JoinColumn(name  = "stud_id" , referencedColumnName = "studentId"))
	@OrderColumn(name = "project_no")
	@ListIndexBase(value = 1)
	private List<String> projects;
	
	
	
	@ElementCollection
	@Column(name = "contact_number")
	@CollectionTable(name = "STUDENT_CONTACTS", joinColumns = @JoinColumn(name = "stud_id", referencedColumnName = "studentId"))
	private Set<Long> contactNo;
	
	
	@ElementCollection
	@Column(name = "CGPA")
	@CollectionTable(name = "STUDENT_SEMMARKS" , joinColumns = @JoinColumn(name="stud_id" , referencedColumnName = "studentId"))
	@MapKeyColumn(name = "Semester_name")
	private Map<String, Float> cgpa;
	
	
	
	
	
}
