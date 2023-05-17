package com.ineuron.dto;

public class StudentDTO {

	private Integer id;
	private String sname;
	private Integer sage;
	private String saddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
	}

}
