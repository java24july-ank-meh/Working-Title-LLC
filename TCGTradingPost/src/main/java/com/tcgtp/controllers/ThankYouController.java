package com.tcgtp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThankYouController {

	@RequestMapping("/thankyou")
	public String thankyou() {
		return "ThankYou";
	}
}
