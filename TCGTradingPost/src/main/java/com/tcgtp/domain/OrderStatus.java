package com.tcgtp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERSTATUS")
public class OrderStatus {
	
	
	private Long statusID;
	
	private String statusName;
	
	// Constructors
	public OrderStatus() {
		super();
	}
	public OrderStatus(Long statusID, String statusName) {
		super();
		this.statusID = statusID;
		this.statusName = statusName;
	}
	
	// Getters and Setters
	
	@Id
	@Column(name="statusID")
	public Long getStatusID() {
		return statusID;
	}
	public void setStatusID(Long statusID) {
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
