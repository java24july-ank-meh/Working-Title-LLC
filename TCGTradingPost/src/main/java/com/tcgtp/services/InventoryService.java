package com.tcgtp.services;

<<<<<<< HEAD
=======
import java.math.BigDecimal;
>>>>>>> master
import java.util.List;

import com.tcgtp.domain.Inventory;

public interface InventoryService {
	List<Inventory> listAll();
	 
	Inventory getById(Long id);
 
<<<<<<< HEAD
	Inventory saveOrUpdate(Inventory order);
 
    void delete(Integer id);
=======
	Inventory saveOrUpdate(Inventory inventory);
	
	List<Inventory> getByGame(String game);
	
	List<Inventory> getBySetName(String setName);
	
	List<Inventory> getByCardName(String cardName);
	
	Inventory getByCardID(String cardID);
	
	List<Inventory> getByPriceMin(BigDecimal minPrice);
	
	List<Inventory> getByPriceMax(BigDecimal maxPrice);
 
    //void delete(Integer id);
>>>>>>> master
}
