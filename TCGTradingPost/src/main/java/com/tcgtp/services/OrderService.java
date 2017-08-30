package com.tcgtp.services;

import java.util.List;

import com.tcgtp.domain.Order;

public interface OrderService {
	
	public List<Order> listAll();
	 
	public Order getById(Long id);
 
	public Order saveOrUpdate(Order order);
 
    public void delete(Long id);
}
