package com.tcgtp.controllers;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tcgtp.domain.Inventory;
import com.tcgtp.services.InventoryService;
import com.tcgtp.services.UserService;

@RestController
public class CardDBSearcherController {
	
	InventoryService inventoryService;
	Gson gson = new Gson();
	
	
	
	@Autowired
    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
	
	@RequestMapping(value = "/cardSearcher", method = RequestMethod.POST)
	public ResponseEntity<String> getCards(
			@RequestParam String cardName,
			@RequestParam String game,
			@RequestParam String setName,
			@RequestParam String PriceMin,
			@RequestParam String PriceMax) {
		
		
		System.out.println("get cards: "+cardName+" "+game+" "+setName+" "+PriceMin+" "+PriceMax);
		
		List<Inventory> cards = inventoryService.listAll();
		System.out.println(gson.toJson(cards));
		// Filters cards
		if (!game.equals("")) {
			List<Inventory> tmp = new ArrayList<Inventory>();
			cards.forEach(item -> {
				if (item.getGame().equalsIgnoreCase(game)) tmp.add(item);
			});
			
			cards = tmp;
		}
		if (!cardName.equals("")) {
			List<Inventory> tmp = new ArrayList<Inventory>();
			cards.forEach(item -> {
				if (item.getCardName().equalsIgnoreCase(cardName)) tmp.add(item);
			});
			
			cards = tmp;
		}
		if (!setName.equals("")) {
			List<Inventory> tmp = new ArrayList<Inventory>();
			cards.forEach(item -> {
				if (item.getSetName().equalsIgnoreCase(setName)) tmp.add(item);
			});
			
			cards = tmp;
		}
		if (!PriceMin.equals("")) {
			List<Inventory> tmp = new ArrayList<Inventory>();
			cards.forEach(item -> {
				if (item.getPrice().compareTo(new BigDecimal(PriceMin)) > -1) tmp.add(item);
			});
			
			cards = tmp;
		}
		if (!PriceMax.equals("")) {
			List<Inventory> tmp = new ArrayList<Inventory>();
			cards.forEach(item -> {
				if (item.getPrice().compareTo(new BigDecimal(PriceMax)) < 1) tmp.add(item);
			});
			
			cards = tmp;
		}
		
		
		
		System.out.println(gson.toJson(cards));
		
		return new ResponseEntity<String>(gson.toJson(cards), HttpStatus.OK);
	}


}
