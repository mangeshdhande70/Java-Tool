package com.mangesh.dto;

import java.io.Serializable;


public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer empid;
	private String unit;
	private String doj;
	private String dob;
	private String photoPath;
	private String idProofPath;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String sname) {
		this.name = sname;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getIdProofPath() {
		return idProofPath;
	}
	public void setIdProofPath(String idProofPath) {
		this.idProofPath = idProofPath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", empid=" + empid + ", unit=" + unit + ", doj=" + doj + ", dob=" + dob
				+ ", photoPath=" + photoPath + ", idProofPath=" + idProofPath + "]";
	}
	
	
	
	


}
