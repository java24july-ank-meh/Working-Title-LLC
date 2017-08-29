package com.tcgtp.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.tcgtp.repositories.OrderStatusRepository;

@Component
public class InitialDatabaseLoading implements ApplicationListener<ContextRefreshedEvent>{

	private OrderStatusRepository orderStatusRepository;
	
	private Logger log = Logger.getLogger(OrderStatusRepository.class);
	
	@Autowired
    public void setProductRepository(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent cre) {
		
		
		
	}
	
}
