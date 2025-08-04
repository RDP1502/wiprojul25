package com.tcs.entity.relationdemo.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "emp_name")
	String employeeName;
	
	@Column(name = "emp_id")
	String empId;
	
	@Column(name = "dept_name")
	String departmentName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "dept_id")
	Department department;

}
