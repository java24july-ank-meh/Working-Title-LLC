package com.tcgtp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tcgtp.domain.User;
import com.tcgtp.services.UserService;

@RestController
public class AccountInfoController {
	
	UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

	@RequestMapping(value="/accountInfo", method=RequestMethod.GET)
	public ResponseEntity<String> accInfo(Authentication authentication) {
		
		System.out.println("principal name: "+authentication.getName());
		
		Gson gson = new Gson();
		
		JsonObject json = new JsonObject();
		
		User currentUser = null;
		for (User usr : userService.listAll()) {
			if (authentication.getName().equals(usr.getUsername())) {
				currentUser = usr;
				break;
			}
		}
		
		json.addProperty("username", currentUser.getUsername());
		json.addProperty("email", currentUser.getEmail());
		json.addProperty("role", gson.toJson(currentUser.getRoles()));
		json.addProperty("account_status", currentUser.getEnabled().toString());
		
		
		return new ResponseEntity<String>(gson.toJson(json) , HttpStatus.OK);
	}
	
}
