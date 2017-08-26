/*package com.tcgtp.hibernate;

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
		initialValue=3000000, allocationSize=1
		)
@Table(name="ORDERS")
public class Order {

	
	private long orderID;
	
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
	
	
	// to String
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customerID=" + customerID + ", datePlaced=" + datePlaced
				+ ", shippingAddress=" + shippingAddress + ", statusID=" + statusID + "]";
	}
	
	//Getters and Setters
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_ORDER_ID_GEN")
	@Column(name="orderID", unique=true, nullable=false)
	public long getOrderID() {
		return orderID;
	}
	@Column(name="customerID", nullable=false)
	public int getCustomerID() {
		return customerID;
	}
	@Column(name="datePlaced", nullable=false)
	public Date getDatePlaced() {
		return datePlaced;
	}
	@Column(name="shippingAddress", nullable=false)
	public String getShippingAddress() {
		return shippingAddress;
	}
	@Column(name="statusID", nullable=false)
	public int getStatusID() {
		return statusID;
	}
	
	
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public void setDatePlaced(Date datePlaced) {
		this.datePlaced = datePlaced;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	
	
	
	
}
*/