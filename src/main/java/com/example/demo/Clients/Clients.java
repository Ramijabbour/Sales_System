package com.example.demo.Clients;


import javax.persistence.*;

@Entity
@Table(name = "Clients")
public class Clients {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ClientID ;
	@Column 
	private String name;
	@Column 
	private String lastName;
	@Column 
	private int mobile;
    
	
	public Clients() {}
	

	public Clients(String name ,String lastName,int mobile) {
		this.name = name;
		this.lastName = lastName ; 
		this.mobile = mobile ; 
		}


	public int getClientID() {
		return ClientID;
	}


	public void setClientID(int clientID) {
		ClientID = clientID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getMobile() {
		return mobile;
	}


	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
}
