package com.tcgtp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class ServletOverlord 
{
	@RequestMapping(value="/Home", method=RequestMethod.GET)
	public String goHome() 
	{
		System.out.println("Fucking thing!!!");
		return "/pages/Home.html";
	}
	
	
	
}
