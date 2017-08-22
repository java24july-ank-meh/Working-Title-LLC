package com.tcgtp.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERSTATUS")
public class OrderStatus {
	
	@Id
	private int statusID;
	@Column
	private String statusName;
	
	// Constructors
	public OrderStatus() {
		super();
	}
	public OrderStatus(int statusID, String statusName) {
		super();
		this.statusID = statusID;
		this.statusName = statusName;
	}
	
	// Getters and Setters
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	// to String
	@Override
	public String toString() {
		return "OrderStatus [statusID=" + statusID + ", statusName=" + statusName + "]";
	}
	
	
	
}
