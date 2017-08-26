/*package com.tcgtp.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(
		name="SQ_ORDERITEM_ID_GEN",
		sequenceName="SQ_ORDERITEM_ID_GEN",
		initialValue=4000000,
		allocationSize=1
		)
@Table(name="ORDERITEM")
public class OrderItem {

	private long orderItemID;
	
	private String itemName;
	private long itemID;
	private int quantity;
	private long orderID;
	
	// Constructors
	public OrderItem() {
		super();
	}

	public OrderItem(String itemName, long itemID, int quantity, long orderID) {
		super();
		this.itemName = itemName;
		this.itemID = itemID;
		this.quantity = quantity;
		this.orderID = orderID;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemID=" + orderItemID + ", itemName=" + itemName + ", itemID=" + itemID + ", quantity="
				+ quantity + ", orderID=" + orderID + "]";
	}

	// Getters and Setters
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_ORDERITEM_ID_GEN")
	@Column(name="orderItemID", unique=true, nullable=false)
	public long getOrderItemID() {
		return orderItemID;
	}
	@Column(name="itemName")
	public String getItemName() {
		return itemName;
	}
	@Column(name="itemID", nullable=false)
	public long getItemID() {
		return itemID;
	}
	@Column(name="quantity", nullable=false)
	public int getQuantity() {
		return quantity;
	}
	@Column(name="orderID", nullable=false)
	public long getOrderID() {
		return orderID;
	}
	

	public void setOrderItemID(long orderItemID) {
		this.orderItemID = orderItemID;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	
	
	
	
}
*/