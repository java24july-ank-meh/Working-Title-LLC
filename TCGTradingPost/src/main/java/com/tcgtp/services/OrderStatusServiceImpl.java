package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcgtp.domain.OrderStatus;
import com.tcgtp.domain.User;
import com.tcgtp.repositories.OrderStatusRepository;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

	private OrderStatusRepository repository;
	
	@Override
	public List<OrderStatus> listAll() {
		List<OrderStatus> orderList = new ArrayList<>();
		repository.findAll().forEach(orderList::add);
		return orderList;
	}

	@Override
	public OrderStatus getById(Long roleID) {
		return repository.findOne(roleID);
	}

	@Override
	public OrderStatus saveOrUpdate(OrderStatus status) {
		return repository.save(status);
	}
	
	@Override
	public OrderStatus findByStatusName(String statusName) {
		return repository.findByStatusName(statusName);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.delete(id);
	}

}
