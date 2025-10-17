package com.wipro.productms.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_details")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "product_name")
	String productName;
	
	@Column(name = "product_desc")
	String productDesc;
	
	@Column(name = "product_cat")
	String productCat;
	
	@Column(name = "make")
	String make;
	
	@Column(name = "available_qty")
	int availableQty;
	
	@Column(name = "price")
	double price;
	
	@Column(name = "uom")
	String uom;
	
	@Column(name = "prod_rating")
	double prodRating;
	
	@Column(name = "img_url")
	String imgUrl;
	
	@Column(name = "date_ofmanufacture")
	LocalDate dateOfManufacture;

}
