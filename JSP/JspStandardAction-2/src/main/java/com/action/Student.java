package com.action;

public class Student {
	
	
	private Integer id;
	
	private String name;
	
	private String addres;
	
	private Integer salary;
	
	
	static {
		System.out.println("Class File Loading");
	}
	
	public Student() {
		
		System.out.println("Object Instatiated");
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
	     System.out.println("Student.setName()");
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		System.out.println("Student.setAddres()");
		this.addres = addres;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		System.out.println("Student.setSalary()");
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", addres=" + addres + ", salary=" + salary + "]";
	}
	
	
}
