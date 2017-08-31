package com.tcgtp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcgtp.domain.Inventory;

@Controller
public class CardSearchController {
	
	@RequestMapping("/cardSearch")
	public String cardSearch() {
		return "CardSearch";
	}
	
	
	
}
