package com.tcgtp.services;

import java.util.List;

import com.tcgtp.domain.Inventory;

public interface InventoryService {
	List<Inventory> listAll();
	 
	Inventory getById(Long id);
 
	Inventory saveOrUpdate(Inventory order);
 
    void delete(Integer id);
}
