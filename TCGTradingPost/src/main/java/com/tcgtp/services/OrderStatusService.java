package com.tcgtp.services;

import java.util.List;

import com.tcgtp.domain.OrderStatus;


public interface OrderStatusService {
	
	public List<OrderStatus> listAll();
	
	public OrderStatus getById(Long id);
	
	public OrderStatus saveOrUpdate(OrderStatus orderStatus);

	public void delete(Long id);
}
