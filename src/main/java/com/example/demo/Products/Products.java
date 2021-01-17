package com.example.demo.Products;


import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ProductID ;
	@Column 
	private String name;
	@Column 
	private String description;
	@Column 
	private String category;
	@Column 
	private Date creationDate;
	
	public Products() {}
	

	public Products(String name ,String description,String category , Date creationDate) {
		this.name = name;
		this.description = description ; 
		this.category = category ; 
		this.creationDate = creationDate; 
		}


	public int getProductID() {
		return ProductID;
	}


	public void setProductID(int productID) {
		ProductID = productID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
