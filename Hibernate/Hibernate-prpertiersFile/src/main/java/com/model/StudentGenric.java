package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class StudentGenric {
	
	@Id
	@GenericGenerator(name = "gen1", strategy = ""  )
	@GeneratedValue(generator = "gen1")
	
	private Integer studId;

}
