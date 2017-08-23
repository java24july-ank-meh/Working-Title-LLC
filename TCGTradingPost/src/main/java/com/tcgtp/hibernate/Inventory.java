package com.tcgtp.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INVENTORY")
public class Inventory {

	
	@Id
	private long itemID;
	@Column
	private String cardName;
	private String game;
	private long cardID;
	
	// Constructors
	public Inventory() {
		super();
	}
	public Inventory(long itemID, String cardName, String game, long cardID) {
		super();
		this.itemID = itemID;
		this.cardName = cardName;
		this.game = game;
		this.cardID = cardID;
	}
	
	// Getters and Setters
	public long getItemID() {
		return itemID;
	}
	public void setItemID(long itemID) {
		this.itemID = itemID;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public long getCardID() {
		return cardID;
	}
	public void setCardID(long cardID) {
		this.cardID = cardID;
	}
	
	// to String
	@Override
	public String toString() {
		return "Inventory [itemID=" + itemID + ", cardName=" + cardName + ", game=" + game + ", cardID=" + cardID + "]";
	}
	
	
}
