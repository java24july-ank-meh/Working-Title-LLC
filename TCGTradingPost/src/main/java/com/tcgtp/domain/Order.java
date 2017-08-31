package com.tcgtp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ORDERS")
public class Order {

	
	private Long orderID;
	
	private User customerID;
	private Date datePlaced;
	private String shippingAddress;
	private OrderStatus statusID;
	
	// Constructors
	public Order() {
		super();
	}
	public Order(Long orderID, User customerID, Date datePlaced, String shippingAddress, OrderStatus statusID) {
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_ORDER_ID")
	@SequenceGenerator(name="SQ_ORDER_ID", sequenceName="SQ_ORDER_ID")
	@Column(name="orderID")
	public Long getOrderID() {
		return orderID;
	}
	@ManyToOne
	@JoinColumn(name="userID")
	public User getCustomerID() {
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
	@ManyToOne
	@JoinColumn(name="statusID")
	public OrderStatus getStatusID() {
		return statusID;
	}
	
	
	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	public void setCustomerID(User customerID) {
		this.customerID = customerID;
	}
	public void setDatePlaced(Date datePlaced) {
		this.datePlaced = datePlaced;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public void setStatusID(OrderStatus statusID) {
		this.statusID = statusID;
	}
	
	
	
	
}
