package com.tcgtp.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tcgtp.domain.OrderStatus;

public class OrderStatusServiceTest {
	private OrderStatusServiceImpl service;
	private Long testID;
	private String testName;

	@Before
	public void setUpBeforeClass() throws Exception {
		OrderStatus test = new OrderStatus();
		test.setStatusName("Test Status");
		service = new OrderStatusServiceImpl();
		test = service.saveOrUpdate(test);
		
		testID = test.getStatusID();
		testName = test.getStatusName();
		
	}

	@After
	public void tearDownAfterClass() throws Exception {
		service.delete(testID);
	}

	@Test
	public void testListAll() {
		List<OrderStatus> statuses = service.listAll();
		for(OrderStatus os : statuses) {
			if(os.getStatusID() == testID) {
				return;
			}
		}
		fail("The OrderStatus I added was not returned in the list.");
	}

	@Test
	public void testGetById() {
		OrderStatus test = service.getById(testID);
		//if the test name of the returned order status is the same as the test name of the role made earlier then pass
		assertTrue(test.getStatusName().equals(testName));
	}
	
	@Test
	public void testGetByName() {
		OrderStatus test = service.findByStatusName(testName);
		//if the test ID of the returned order status is the same as the test ID of the role made earlier then pass
		assertTrue(test.getStatusID() == testID);
	}

	@Ignore
	@Test
	public void testSaveOrUpdate() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}