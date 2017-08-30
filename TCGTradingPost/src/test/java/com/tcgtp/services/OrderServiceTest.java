package com.tcgtp.services;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tcgtp.domain.Order;

public class OrderServiceTest {
	private OrderServiceImpl service;
	private Long testID;
	private String testName;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Order test = new Order();
		test.setDatePlaced(new Date(System.currentTimeMillis()));
		/* I am going to hold off on finishing this test because it will be doing the same exact thing
		 * so I want to make sure that all of the other tests that I have already written can pass
		 * before I mindlessly continue writing these mundane tests that feel rather pointless at this point. */
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
