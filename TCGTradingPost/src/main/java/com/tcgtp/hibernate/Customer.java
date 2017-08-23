package com.tcgtp.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(
		name="SQ_CUSTOMER_ID_GEN",
		sequenceName="SQ_CUSTOMER_ID_GEN",
		initialValue=2000000,
		allocationSize=1
		)
@Table(name="CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_CUSTOMER_ID_GEN")
	private long customerID;
	
	@Column
	private String username;
	private String password;
	private String email;
	
	// Constructors
	public Customer() {
		super();
	}
	public Customer(long customerID, String username, String password, String email) {
		super();
		this.customerID = customerID;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	// Getters and Setters
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// to String
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", username=" + username + ", password=" + password + ", email="
				+ email + "]";
	}
	
	
	
}
