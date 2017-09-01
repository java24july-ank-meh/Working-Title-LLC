package com.tcgtp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tcgtp.domain.Inventory;
import com.tcgtp.domain.OrderItem;
import com.tcgtp.services.InventoryService;
import com.tcgtp.services.OrderItemService;

@RestController
public class BuyController {
	
	InventoryService inventoryService;
	@Autowired
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	@SuppressWarnings("unchecked") // Nothing wrong
	@RequestMapping("/buyItem")
	public ResponseEntity<String> buyItem(@RequestParam String cardID) {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		List<OrderItem> cart = (List<OrderItem>) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<OrderItem>();
		}
		
		// Find the wanted item in inventory
		Inventory cartItem = null;
		for (Inventory item : inventoryService.listAll()) {
			if (item.getCardID().equals(cardID)) {
				cartItem = item;
				break;
			}
		}
		
		// Decrement Inventory item
		cartItem.setStock(cartItem.getStock() - 1);
		if (cartItem.getStock() < 0) {
			return new ResponseEntity<String>("Out of stock!", HttpStatus.OK);
		}
		
		
		
		// Add item to cart
		OrderItem orderItem = new OrderItem();
		orderItem.setItemID(cartItem);
		orderItem.setItemName(cartItem.getCardName());
		orderItem.setQuantity(1);
		
		cart.add(orderItem);
		
		
		// Stored cart back in Request Context
		request.getSession().setAttribute("cart", cart);
		
		
		// Save inventory item
		inventoryService.saveOrUpdate(cartItem);
		
		
		
		return new ResponseEntity<String>("Item added to cart.", HttpStatus.OK);
	}

}
