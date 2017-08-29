package com.tcgtp.services;

import java.util.List;

import com.tcgtp.domain.OrderStatus;

public interface OrderStatusService {
	
	public List<OrderStatus> listAll();
	
	public OrderStatus getById(Long roleID);
	
	public OrderStatus saveOrUpdate(OrderStatus role);

	public void delete(Long id);
}
