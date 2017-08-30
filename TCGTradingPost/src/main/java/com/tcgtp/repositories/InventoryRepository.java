package com.tcgtp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tcgtp.domain.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {

}