package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import com.tcgtp.domain.Inventory;
import com.tcgtp.repositories.InventoryRepository;

public class InventoryServiceImpl implements InventoryService {

	private InventoryRepository inventoryRepository;
	
	@Override
	public List<Inventory> listAll() {
		List<Inventory> inventoryList = new ArrayList<>();
		inventoryRepository.findAll().forEach(inventoryList::add);
		return inventoryList;
	}

	@Override
	public Inventory getById(Long id) {
		return inventoryRepository.findOne(id);
	}

	@Override
	public Inventory saveOrUpdate(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

}
