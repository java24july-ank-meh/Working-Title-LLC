package com.tcgtp.services;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import com.tcgtp.domain.User;
import com.tcgtp.services.UserDetailsServiceImpl;
import com.tcgtp.services.UserServiceImpl;

public class UserDetailsServiceTest {
	private Long testID;
	private String testUsername;
	private String testPassword;
	
	@Before
	public void setUp() throws Exception {
		User test = new User();
		test.setUsername("NekoGirl");
		test.setEmail("Lala@gmail.com");
		test.setPassword("HelloThere");
		
		UserServiceImpl service = new UserServiceImpl();
		test = service.saveOrUpdate(test);
		testID = test.getUserID();
		testUsername = test.getUsername();
		testPassword = test.getPassword();
	}

	@After
	public void tearDown() throws Exception {
		UserServiceImpl service = new UserServiceImpl();
		service.delete(testID);
	}

	@Test
	public void testLoadUserByUsername() {
		UserDetailsServiceImpl service = new UserDetailsServiceImpl();
		UserDetails details = service.loadUserByUsername(testUsername);
		assertTrue(details.getUsername().equals(testUsername));
		
		//I don't know if the password in here is encrypted or not so perhaps get rid of this one
		assertTrue(details.getPassword().equals(testPassword));
	}

}
