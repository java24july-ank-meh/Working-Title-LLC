package com.tcgtp.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@SequenceGenerator(
		name="SQ_ORDER_ID_GEN",
		sequenceName="SQ_ORDER_ID_GEN",
		initialValue=1000000, allocationSize=1
		)
@Table(name="ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_ORDER_ID_GEN")
	private long orderID;
	
	@Column
	private int customerID;
	private Date datePlaced;
	private String shippingAddress;
	private int statusID;
	
	// Constructors
	public Order() {
		super();
	}
	public Order(long orderID, int customerID, Date datePlaced, String shippingAddress, int statusID) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.datePlaced = datePlaced;
		this.shippingAddress = shippingAddress;
		this.statusID = statusID;
	}
	
	// Getters and Setters
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public Date getDatePlaced() {
		return datePlaced;
	}
	public void setDatePlaced(Date datePlaced) {
		this.datePlaced = datePlaced;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	
	// to String
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customerID=" + customerID + ", datePlaced=" + datePlaced
				+ ", shippingAddress=" + shippingAddress + ", statusID=" + statusID + "]";
	}
	
	
	
	
}
