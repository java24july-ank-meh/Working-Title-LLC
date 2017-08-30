package com.tcgtp.services;

import java.util.List;

import com.tcgtp.domain.Inventory;

public interface InventoryService {

	public List<Inventory> listAll();
	
	public Inventory getById(Long id);
	
	public Inventory saveOrUpdate(Inventory inventory);

	//public void delete(Long id); //Once we have an item in the inventory we will never delete it
}
