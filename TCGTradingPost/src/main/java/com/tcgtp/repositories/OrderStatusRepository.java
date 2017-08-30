package com.tcgtp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tcgtp.domain.OrderStatus;

public interface OrderStatusRepository extends CrudRepository<OrderStatus, Integer>{

}
