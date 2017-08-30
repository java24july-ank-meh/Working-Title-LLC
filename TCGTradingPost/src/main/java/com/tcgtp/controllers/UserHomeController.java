package com.tcgtp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserHomeController {
		
	@RequestMapping("/userHome")
	public String userhome() {
		return "UserHome";
	}
	
	@RequestMapping("/partial_UserHome_accountInfo")
	public String accountInfo() {
		return "partial_UserHome_accountInfo";
	}
	
	@RequestMapping("/partial_UserHome_cart")
	public String cart() {
		return "partial_UserHome_cart";
	}
	
	@RequestMapping("/partial_UserHome_orderHistory")
	public String orderHistory() {
		return "partial_UserHome_orderHistory";
	}
}