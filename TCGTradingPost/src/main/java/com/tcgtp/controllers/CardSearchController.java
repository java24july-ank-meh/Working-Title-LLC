package com.tcgtp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CardSearchController {
	@RequestMapping("/cardSearch")
	public String cardSearch() {
		return "CardSearch";
	}
}
