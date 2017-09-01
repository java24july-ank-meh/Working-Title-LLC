package com.tcgtp.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tcgtp.domain.Order;
import com.tcgtp.domain.User;
import com.tcgtp.services.OrderService;
import com.tcgtp.services.UserService;

@RestController
public class OrderHistoryController {
	UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	OrderService orderService;
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@RequestMapping(value="/orderHistoryLoad", method=RequestMethod.GET)
	public void orderHistory(Authentication authentication, Model model){
		Gson gson = new Gson();
		
		User currentUser = null;
		for(User user : userService.listAll()) {
			if(authentication.getName().equals(user.getUsername())) {
				currentUser = user;
				break;
			}
		}
		
		List<Order> orders = new ArrayList<>();
		for(Order order : orderService.listAll()) {
			if(order.getCustomerID().getUserID() == currentUser.getUserID()) {
				orders.add(order);
			}
		}
		
		model.addAttribute("ordersModel", "aadsdfsdafdsaf");
	}
}
