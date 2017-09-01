package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcgtp.domain.Order;
import com.tcgtp.repositories.OrderItemRepository;
import com.tcgtp.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository repository;
	@Autowired
    public void setOrderRepository(OrderRepository repository) {
        this.repository = repository;
    }
	
	@Override
	public List<Order> listAll() {
		List<Order> orderList = new ArrayList<>();
		repository.findAll().forEach(orderList::add);
		return orderList;
	}

	@Override
	public Order getById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Order saveOrUpdate(Order order) {
		return repository.save(order);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.delete(id);

	}

}
