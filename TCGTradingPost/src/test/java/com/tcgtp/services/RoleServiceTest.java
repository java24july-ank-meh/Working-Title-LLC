package com.tcgtp.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tcgtp.domain.Role;

public class RoleServiceTest {
	RoleServiceImpl service;
	Long testID;
	String testName;

	@Before
	public void setUp() throws Exception {
		Role test = new Role();
		test.setRoleName("Tester");
		service = new RoleServiceImpl();
		test = service.saveOrUpdate(test);
		
		testID = test.getId();
		testName = test.getRoleName();
	}

	@After
	public void tearDown() throws Exception {
		service.delete(testID);
	}

	@Test
	public void testListAll() {
		List<Role> roles = service.listAll();
		for(Role r : roles) {
			if(r.getId() == testID) {
				return;
			}
		}
		fail("The Role I added was not returned in the list.");
	}

	@Test
	public void testGetById() {
		Role test = service.getById(testID);
		//if the test name of the returned Role is the same as the test name of the role made earlier then pass
		assertTrue(test.getRoleName().equals(testName));
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
