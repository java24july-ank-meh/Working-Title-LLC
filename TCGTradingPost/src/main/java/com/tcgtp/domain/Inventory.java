package com.tcgtp.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INVENTORY")
public class Inventory {

	
	
	private Long itemID;

	private String cardName;
	private String game;
	private String setName;
	private String cardID;
	private BigDecimal price;
	private Integer stock;
	
	// Constructors
	public Inventory() {
		super();
	}
	
	
	
	
	
	// Setters
	
	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setStock(Integer stock)	 {
		this.stock = stock;
	}
	public void setSetName(String setName)	 {
		this.setName = setName;
	}
	
	
	
	
	//Getters
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_INVENTORY_ID")
	@SequenceGenerator(name="SQ_INVENTORY_ID", sequenceName="SQ_INVENTORY_ID")
	@Column(name="itemID")
	public Long getItemID() {
		return itemID;
	}
	@Column(name="cardName", nullable=false)
	public String getCardName() {
		return cardName;
	}
	@Column(name="game", nullable=false)
	public String getGame() {
		return game;
	}
	@Column(name="setName")
	public String getSetName() {
		return setName;
	}
	@Column(name="cardID", nullable=false, unique=true)
	public String getCardID() {
		return cardID;
	}
	@Column(name="price", nullable=false)
	public BigDecimal getPrice() {
		return price;
	}
	@Column(name="stock", nullable=false)
	public Integer getStock() {
		return stock;
	}



	
	
	
}
