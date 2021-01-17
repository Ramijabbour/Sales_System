package com.example.demo.Sales;


import java.util.Date;

import javax.persistence.*;

import com.example.demo.Clients.Clients;
import com.example.demo.Products.Products;

@Entity
@Table(name = "Sales")
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int SaleID ;
	@Column 
	private String quantities;
	@Column 
	private String seller;
	@Column 
	private String price;
	@Column 
	private Date creation_date;
	@ManyToOne
	private Clients client ; 
    @ManyToOne
    private Products product ; 
	
	public Sales() {}

	public Sales(String quantities, String seller,String price, Date creation_date, Clients client, Products product) {
		super();
		this.quantities = quantities;
		this.seller = seller;
		this.price=price;
		this.creation_date = creation_date;
		this.client = client;
		this.product = product;
	}

	public int getSaleID() {
		return SaleID;
	}

	public void setSaleID(int saleID) {
		SaleID = saleID;
	}

	public String getQuantities() {
		return quantities;
	}

	public void setQuantities(String quantities) {
		this.quantities = quantities;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
	
	

}
