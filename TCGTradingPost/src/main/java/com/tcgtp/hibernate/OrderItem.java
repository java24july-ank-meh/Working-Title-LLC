package com.tcgtp.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Inventory itemID;
	private int quantity;
	private Order orderID;
	
	// Constructors
	public OrderItem() {
		super();
	}

	public OrderItem(String itemName, Inventory itemID, int quantity, Order orderID) {
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
	@Column(name="orderItemID")
	public long getOrderItemID() {
		return orderItemID;
	}
	@Column(name="itemName")
	public String getItemName() {
		return itemName;
	}
	@ManyToOne
	@JoinColumn(name="itemID")
	public Inventory getItemID() {
		return itemID;
	}
	@Column(name="quantity", nullable=false)
	public int getQuantity() {
		return quantity;
	}
	@ManyToOne
	@JoinColumn(name="orderID")
	public Order getOrderID() {
		return orderID;
	}
	

	public void setOrderItemID(long orderItemID) {
		this.orderItemID = orderItemID;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemID(Inventory itemID) {
		this.itemID = itemID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setOrderID(Order orderID) {
		this.orderID = orderID;
	}
	
	
	
	
}
