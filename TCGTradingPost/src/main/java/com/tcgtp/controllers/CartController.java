package com.tcgtp.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tcgtp.domain.Order;
import com.tcgtp.domain.OrderItem;
import com.tcgtp.domain.OrderStatus;
import com.tcgtp.services.OrderItemService;
import com.tcgtp.services.OrderService;
import com.tcgtp.services.OrderStatusService;
import com.tcgtp.services.UserService;

@Controller
public class CartController {
	
	OrderService orderService;
	OrderItemService orderItemService;
	OrderStatusService orderStatusService;
	UserService userService;
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Autowired
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setOrderStatusService(OrderStatusService orderStatusService) {
		this.orderStatusService = orderStatusService;
	}
	
	@RequestMapping("/cart")
	public String cartPage() {
		return "Cart";
	}
	
	
	@SuppressWarnings("unchecked") // Nothing wrong
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(Authentication auth, @RequestParam String address) {
		
		// Get the user's cart
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		List<OrderItem> cart = (List<OrderItem>) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<OrderItem>();
		}
		
		// Create new order
		Order order = new Order();
		order.setCustomerID(userService.findByUsername(auth.getName()));
		order.setDatePlaced(new Date());
		order.setShippingAddress(address);
		
		OrderStatus status = null;
		for (OrderStatus o : orderStatusService.listAll()) {
			if (o.getStatusName().equalsIgnoreCase("NOT SHIPPED")) {
				status = o;
			}
		}
		
		order.setStatusID(status);
		
		orderService.saveOrUpdate(order);
		
		for (Order o : orderService.listAll()) {
			if (o.getDatePlaced().equals(order.getDatePlaced())) {
				order = o;
			}
		}
		
		
		
		// Save cart to database
		for (OrderItem cartItem : cart) {
			cartItem.setOrderID(order);
			orderItemService.saveOrUpdate(cartItem);
		}
		
		
		// Clear cart
		cart = new ArrayList<OrderItem>();
		request.getSession().setAttribute("cart", cart);
		
		
		return "redirect:/thankyou";
	}
	
}
