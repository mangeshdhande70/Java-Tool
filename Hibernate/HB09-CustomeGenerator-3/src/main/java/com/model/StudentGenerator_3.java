package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class StudentGenerator_3 {

 @Id
 @GenericGenerator(name = "gen1" , strategy = "com.hibernate.customeGen.MyCustomeIdGen")
 @GeneratedValue(generator = "gen1")
  private Integer id; 
 
 @Column(name = "name")
  private String name;


public StudentGenerator_3() {
	super();
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}




public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

@Override
public String toString() {
	return "StudentGenric [id=" + id + ", name=" + name + "]";
}
 
 
	
	
}
