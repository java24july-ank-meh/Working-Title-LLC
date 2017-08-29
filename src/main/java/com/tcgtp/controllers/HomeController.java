package com.tcgtp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HomeController {
	@RequestMapping("/")
	String home() {
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	String login() {
		return "Login";
	}
	
	@RequestMapping("/cardsearch")
	String cardSearch() {
		return "CardSearch";
	}
}

