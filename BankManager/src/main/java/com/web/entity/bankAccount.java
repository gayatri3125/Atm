package com.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class bankAccount {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private int accountBalance;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAccountBalance() {
	return accountBalance;
}
public void setAccountBalance(int accountBalance) {
	this.accountBalance = accountBalance;
}
@Override
public String toString() {
	return "bankAccount [id=" + id + ", accountBalance=" + accountBalance + "]";
}
public bankAccount(int id, int accountBalance) {
	super();
	this.id = id;
	this.accountBalance = accountBalance;
}
public bankAccount() {
	super();
	// TODO Auto-generated constructor stub
}



}
