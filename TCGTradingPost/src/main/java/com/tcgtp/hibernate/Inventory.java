package com.tcgtp.hibernate;

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

	
	
	private long itemID;

	private String cardName;
	private String game;
	private long cardID;
	
	// Constructors
	public Inventory() {
		super();
	}
	public Inventory(String cardName, String game, long cardID) {
		super();
		this.cardName = cardName;
		this.game = game;
		this.cardID = cardID;
	}
	
	
	// to String
	@Override
	public String toString() {
		return "Inventory [itemID=" + itemID + ", cardName=" + cardName + ", game=" + game + ", cardID=" + cardID + "]";
	}
	
	//Getters and Setters
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_INVENTORY_ID_GEN")
	@Column(name="itemID", unique=true, nullable=false)
	public long getItemID() {
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
	@Column(name="cardID", nullable=false)
	public long getCardID() {
		return cardID;
	}
	
	
	public void setItemID(long itemID) {
		this.itemID = itemID;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public void setCardID(long cardID) {
		this.cardID = cardID;
	}
	
	
}
