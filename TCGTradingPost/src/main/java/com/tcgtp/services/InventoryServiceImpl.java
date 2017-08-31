package com.tcgtp.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcgtp.domain.Inventory;
import com.tcgtp.repositories.InventoryRepository;
import com.tcgtp.repositories.UserRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	private InventoryRepository inventoryRepository;
	@Autowired
    public void setInventoryRepository(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
	
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

	@Override
	public List<Inventory> getByGame(String game) {
		List<Inventory> inventoryList = new ArrayList<>();
		
		inventoryRepository.findAll().forEach( item -> {
					if (item.getGame().equalsIgnoreCase(game)) {
						inventoryList.add(item);
					}
				});
		
		return inventoryList;
	}

	@Override
	public List<Inventory> getBySetName(String setName) {
		List<Inventory> inventoryList = new ArrayList<>();
		
		inventoryRepository.findAll().forEach( item -> {
					if (item.getSetName().equalsIgnoreCase(setName)) {
						inventoryList.add(item);
					}
				});
		
		return inventoryList;
	}

	@Override
	public List<Inventory> getByCardName(String cardName) {
		List<Inventory> inventoryList = new ArrayList<>();
		
		inventoryRepository.findAll().forEach( item -> {
					if (item.getCardName().equalsIgnoreCase(cardName)) {
						inventoryList.add(item);
					}
				});
		
		return inventoryList;
	}

	@Override
	public Inventory getByCardID(String cardID) {
		for (Inventory i : inventoryRepository.findAll()) {
			if (i.getCardID().equalsIgnoreCase(cardID)) return i;
		}
		
		return null;
	}

	@Override
	public List<Inventory> getByPriceMin(BigDecimal minPrice) {
		List<Inventory> inventoryList = new ArrayList<>();
		
		inventoryRepository.findAll().forEach( item -> {
					if (item.getPrice().compareTo(minPrice) > -1) {
						inventoryList.add(item);
					}
				});
		
		return inventoryList;
	}

	@Override
	public List<Inventory> getByPriceMax(BigDecimal maxPrice) {
		List<Inventory> inventoryList = new ArrayList<>();
		
		inventoryRepository.findAll().forEach( item -> {
					if (item.getPrice().compareTo(maxPrice) < 1) {
						inventoryList.add(item);
					}
				});
		
		return inventoryList;
	}

	
}
