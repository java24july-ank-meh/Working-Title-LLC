package com.tcgtp.services;

<<<<<<< HEAD
public class OrderItemService {

=======
import java.util.List;

import com.tcgtp.domain.OrderItem;

public interface OrderItemService {
	
	public List<OrderItem> listAll();
	
	public OrderItem getById(Long id);
	
	public OrderItem saveOrUpdate(OrderItem item);

	public void delete(Long id);
>>>>>>> master
}
