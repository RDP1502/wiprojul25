package com.wipro.springdemo.beans;

public class College {
	String clgName;
	Department departmet;
	public String getClgName() {
		return clgName;
	}
	public void setClgName(String clgName) {
		this.clgName = clgName;
	}
	public Department getDepartmet() {
		return departmet;
	}
	public void setDepartmet(Department departmet) {
		this.departmet = departmet;
	}
	@Override
	public String toString() {
		return "College [clgName=" + clgName + ", departmet=" + departmet + "]";
	}
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(String clgName, Department departmet) {
		super();
		this.clgName = clgName;
		this.departmet = departmet;
	}
	
	

}
