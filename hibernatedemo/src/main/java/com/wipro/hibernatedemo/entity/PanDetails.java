package com.wipro.hibernatedemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pandetails")
public class PanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "panholder_name")
	String panHolderName;
	
	@Column(name = "pan_number")
	String panNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPanHolderName() {
		return panHolderName;
	}

	public void setPanHolderName(String panHolderName) {
		this.panHolderName = panHolderName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	@Override
	public String toString() {
		return "PanDetails [id=" + id + ", panHolderName=" + panHolderName + ", panNumber=" + panNumber + "]";
	}

	public PanDetails(String panHolderName, String panNumber) {
		super();
		this.panHolderName = panHolderName;
		this.panNumber = panNumber;
	}
	

	public PanDetails(int id, String panHolderName, String panNumber) {
		super();
		this.id = id;
		this.panHolderName = panHolderName;
		this.panNumber = panNumber;
	}

	public PanDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
