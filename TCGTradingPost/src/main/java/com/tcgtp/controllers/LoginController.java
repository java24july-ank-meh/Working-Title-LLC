package com.tcgtp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	String login() {
		return "Login";
	}
}
