package com.tcgtp.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EncryptionServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEncryptString() {
		EncryptionServiceImpl service = new EncryptionServiceImpl();
		String test = "HelloThere";
		//make sure it works by making sure that the end result of the encryption is not the same as the original
		assertFalse(test.equals(service.encryptString(test)));
	}

	@Test
	public void testCheckPassword() {
		EncryptionServiceImpl service = new EncryptionServiceImpl();
		String test = "HelloThere";
		String codedTest = service.encryptString(test);
		assertTrue(service.checkPassword(test, codedTest));
	}

}
