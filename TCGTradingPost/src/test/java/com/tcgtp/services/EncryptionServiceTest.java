package com.tcgtp.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncryptionServiceTest {

	private EncryptionService encryptionService;
	
	@Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

	@Test
	public void testEncryptString() {
		String test = "HelloThere";
		//make sure it works by making sure that the end result of the encryption is not the same as the original
		assertFalse(test.equals(encryptionService.encryptString(test)));
	}

	@Test
	public void testCheckPassword() {
		String test = "HelloThere";
		String codedTest = encryptionService.encryptString(test);
		assertTrue(encryptionService.checkPassword(test, codedTest));
	}

}
