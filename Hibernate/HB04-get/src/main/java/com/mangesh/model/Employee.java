package com.mangesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Employee_Table")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;
	
	
	@Column(name = "employee_name")
	private String empolyeeName;
	
	@Column(name = "salary")
	private Float salary;
	
	@Column(name = "experience_year")
	private Byte experience;

	public Employee() {
		super();
	}

	public String getEmpolyeeName() {
		return empolyeeName;
	}

	public void setEmpolyeeName(String empolyeeName) {
		this.empolyeeName = empolyeeName;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Byte getExperience() {
		return experience;
	}

	public void setExperience(int i) {
		this.experience = (byte) i;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empolyeeName=" + empolyeeName + ", salary=" + salary
				+ ", experience=" + experience + "]";
	}
	
	
	

}
