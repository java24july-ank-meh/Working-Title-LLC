package com.tcgtp.services;

import java.util.List;

import com.tcgtp.domain.Order;

public interface OrderService {
	List<Order> listAll();
	 
	Order getById(Long id);
 
	Order saveOrUpdate(Order order);
 
    void delete(Integer id);
}
