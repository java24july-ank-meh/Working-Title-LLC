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
@SequenceGenerator(
		name="SQ_INVENTORY_ID_GEN",
		sequenceName="SQ_INVENTORY_ID_GEN",
		initialValue=1000000, allocationSize=1
		)
@Table(name="INVENTORY")
public class Inventory {

	
	
	private Long itemID;

	private String cardName;
	private String game;
	private Long cardID;
	private BigDecimal price;
	private Integer stock;
	
	// Constructors
	public Inventory() {
		super();
	}
	public Inventory(String cardName, String game, Long cardID, BigDecimal price, Integer stock) {
		super();
		this.cardName = cardName;
		this.game = game;
		this.cardID = cardID;
		this.price = price;
		this.stock = stock;
	}
	
	
	//Getters and Setters
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SQ_INVENTORY_ID_GEN")
	@Column(name="itemID")
	public Long getItemID() {
		return itemID;
	}
	@Column(name="cardName", nullable=false, length=200)
	public String getCardName() {
		return cardName;
	}
	@Column(name="game", nullable=false, length=30)
	public String getGame() {
		return game;
	}
	@Column(name="cardID", nullable=false, unique=true)
	public Long getCardID() {
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
	
	
	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public void setCardID(Long cardID) {
		this.cardID = cardID;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setStock(Integer stock)	 {
		this.stock = stock;
	}
	
	
}