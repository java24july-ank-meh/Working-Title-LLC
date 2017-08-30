package com.tcgtp.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tcgtp.domain.User;

public class UserServicesTest {
	private UserServiceImpl service;
	private Long testID;
	private String testUsername;

	@Before
	public void setUp() throws Exception {
		User test = new User();
		test.setUsername("NekoGirl");
		test.setEmail("Lala@gmail.com");
		test.setPassword("HelloThere");
		
		service = new UserServiceImpl();
		test = service.saveOrUpdate(test);
		testID = test.getUserID();
		testUsername = test.getUsername();
	}

	@After
	public void tearDown() throws Exception {
		service.delete(testID);
	}

	@Test
	public void testListAll() throws Exception {
		List<User> users = service.listAll();
		for(User u : users) {
			if(u.getUsername().equals("NekoGirl")) {
				return;
			}
		}
		fail("The new User I made was not found");
	}

	@Test
	public void testGetById() {
		User test = service.getById(testID);
		//ensure that it is the same by making sure that the Username is what we set after getting an object by ID
		assertTrue(testUsername.equals(test.getUsername()));
	}

	@Test
	public void testFindByUsername() {
		User test = service.findByUsername(testUsername);
		//make sure it is the same by checking that it matches the ID from the setup
		assertTrue(testID == test.getUserID());
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
