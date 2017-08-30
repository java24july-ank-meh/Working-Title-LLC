package com.tcgtp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tcgtp.domain.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long>{

}
