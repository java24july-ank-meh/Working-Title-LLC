package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcgtp.domain.Order;
import com.tcgtp.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	
	@Override
	public List<Order> listAll() {
		List<Order> orderList = new ArrayList<>();
		orderRepository.findAll().forEach(orderList::add);
		return orderList;
	}

	@Override
	public Order getById(Long id) {
		return orderRepository.findOne(id);
	}

	@Override
	public Order saveOrUpdate(Order order) {
		return orderRepository.save(order);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		orderRepository.delete(id);

	}

}
