package com.tcgtp.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tcgtp.domain.OrderItem;

@RestController
public class CartLoaderController {

	@SuppressWarnings("unchecked") // There is nothing wrong with casting "cart" attribute from Object to List
	@RequestMapping("/getCart")
	public ResponseEntity<String> getCart() {
		Gson gson = new Gson();
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		List<OrderItem> orderItems = (List<OrderItem>) request.getSession().getAttribute("cart");
		if (orderItems == null) {
			System.out.println("Cart is null");
			orderItems = new ArrayList<OrderItem>();
		}
		
		List<JsonObject> jsonArr = new ArrayList<>();
		for (OrderItem i : orderItems) {
			JsonObject json = new JsonObject();
			json.addProperty("cardName", i.getItemID().getCardName());
			json.addProperty("price", i.getItemID().getPrice());
			json.addProperty("quantity", i.getQuantity());
			json.addProperty("cardID", i.getItemID().getCardID());
			jsonArr.add(json);
		}
		
		System.out.println("getCart JSON: "+gson.toJson(jsonArr));
		
		return new ResponseEntity<String>(gson.toJson(jsonArr), HttpStatus.OK);
	}
}
