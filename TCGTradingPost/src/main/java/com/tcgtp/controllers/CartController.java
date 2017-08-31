package com.tcgtp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tcgtp.domain.OrderItem;
import com.tcgtp.domain.User;
import com.tcgtp.services.InventoryService;
import com.tcgtp.services.OrderItemService;
import com.tcgtp.services.OrderService;
import com.tcgtp.services.UserService;

@RestController
public class CartController {
	UserService userService;
	OrderItemService oIService;
	OrderService oService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setoIService(OrderItemService oIService) {
		this.oIService = oIService;
	}
	@Autowired
	public void setoService(OrderService oService) {
		this.oService = oService;
	}
	
	public ResponseEntity<String> cartWorkings(Authentication authentication) {
		Gson gson = new Gson();
		List<OrderItem> oList = new ArrayList<>();
		
		User currentUser = null;
		for(User user : userService.listAll()) {
			if(authentication.getName().equals(user.getUsername())) {
				currentUser = user;
				break;
			}
		}
		
		
		for(OrderItem item: oIService.listAll()) {
			if(item.getOrderID().getCustomerID().equals(currentUser)) {
				oList.add(item);
			}
		}
		
		return new ResponseEntity<String>(gson.toJson(oList), HttpStatus.OK);
	}

}
