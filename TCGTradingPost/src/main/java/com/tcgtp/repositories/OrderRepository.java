package com.tcgtp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tcgtp.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
