package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class StudentGenric {

 @Id
 @GenericGenerator(name = "gen1" , strategy = "com.hibernate.customeGen.MyCustomeIdGen")
 @GeneratedValue(generator = "gen1")
  private String id; 
 
 @Column(name = "name")
  private String name;

public StudentGenric(String id, String name) {
	super();
	this.id = id;
	this.name = name;
}

public StudentGenric() {
	super();
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getId() {
	return id;
}

@Override
public String toString() {
	return "StudentGenric [id=" + id + ", name=" + name + "]";
}
 
 
	
	
}
