package com.mangesh.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;


@Entity
@DynamicInsert(value = true)
public class EmployeeDynamic {
	
	
	@Id

	private Integer employeeId;
	
	
	private String empolyeeName;
	
	private Float salary;
	
	private Byte experience;

	 public EmployeeDynamic() {
		// TODO Auto-generated constructor stub
	}
	 
	public String getEmpolyeeName() {
		return empolyeeName;
	}
	
	

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public void setExperience(Byte experience) {
		this.experience = experience;
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
