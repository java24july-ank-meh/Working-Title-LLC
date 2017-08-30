package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcgtp.domain.OrderStatus;
import com.tcgtp.repositories.OrderStatusRepository;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

	private OrderStatusRepository orderStatusRepository;
	
	@Override
	public List<OrderStatus> listAll() {
		List<OrderStatus> orderList = new ArrayList<>();
		orderStatusRepository.findAll().forEach(orderList::add);
		return orderList;
	}

	@Override
	public OrderStatus getById(Long roleID) {
		return orderStatusRepository.findOne(roleID);
	}

	@Override
	public OrderStatus saveOrUpdate(OrderStatus role) {
		return orderStatusRepository.save(role);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		orderStatusRepository.delete(id);

	}

}
