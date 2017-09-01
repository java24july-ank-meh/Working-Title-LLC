package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcgtp.domain.OrderStatus;
import com.tcgtp.repositories.OrderRepository;
import com.tcgtp.repositories.OrderStatusRepository;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

	private OrderStatusRepository orderStatusRepository;
	@Autowired
    public void setOrderRepository(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }
	
	@Override
	public List<OrderStatus> listAll() {
		List<OrderStatus> orderList = new ArrayList<>();
		orderStatusRepository.findAll().forEach(orderList::add);
		return orderList;
	}

	@Override
	public OrderStatus getById(Long id) {
		return orderStatusRepository.findOne(id);
	}

	@Override
	public OrderStatus saveOrUpdate(OrderStatus orderStatus) {
		System.out.println(orderStatus.getStatusName());
		return orderStatusRepository.save(orderStatus);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		orderStatusRepository.delete(id);

	}



}
