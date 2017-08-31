package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcgtp.domain.OrderItem;
import com.tcgtp.repositories.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemRepository repository;
	
	@Override
	public List<OrderItem> listAll() {
		List<OrderItem> userList = new ArrayList<>();
		repository.findAll().forEach(userList::add);
		return userList;
	}

	@Override
	public OrderItem getById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public OrderItem saveOrUpdate(OrderItem item) {
		return repository.save(item);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.delete(id);

	}

}
