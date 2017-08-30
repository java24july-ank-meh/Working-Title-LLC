package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcgtp.domain.Inventory;
import com.tcgtp.repositories.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	private InventoryRepository repository;
	
	@Override
	public List<Inventory> listAll() {
		List<Inventory> inventoryList = new ArrayList<>();
		repository.findAll().forEach(inventoryList::add);
		return inventoryList;
	}

	@Override
	public Inventory getById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Inventory saveOrUpdate(Inventory inventory) {
		return repository.save(inventory);
	}

}
