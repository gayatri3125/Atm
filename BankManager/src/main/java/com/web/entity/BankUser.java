package com.web.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class BankUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String email;
	private String name;
	private int pincode;

	
	@OneToOne
	private bankAccount bankaccount;
	  
	  

	 
	@Override
	public String toString() {
		return "BankUser [id=" + id + ", email=" + email + ", name=" + name + ", pincode=" + pincode + ", bankaccount="
				+ bankaccount + "]";
	}
	public bankAccount getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(bankAccount bankaccount) {
		this.bankaccount = bankaccount;
	}
	public BankUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankUser(int id, String email, String name, int pincode) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	

}
