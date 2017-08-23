package com.tcgtp.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERSTATUS")
public class OrderStatus {
	
	
	private int statusID;
	
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
	
	@Id
	@Column(name="statusID", unique=true, nullable=false)
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	
	@Column(name="statusName", unique=true, nullable=false)
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
