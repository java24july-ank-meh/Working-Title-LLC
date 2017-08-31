package com.tcgtp.services;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {
	
	StrongPasswordEncryptor strongPasswordEncryptor;
	@Autowired
	public void setStrongPasswordEncryptor(StrongPasswordEncryptor strongPasswordEncryptor) {
		this.strongPasswordEncryptor = strongPasswordEncryptor;
	}

	
	public String encryptString(String str) {
		return strongPasswordEncryptor.encryptPassword(str);
	}

	
	public boolean checkPassword(String plainPassword, String encryptedPassword) {
		return strongPasswordEncryptor.checkPassword(plainPassword, encryptedPassword);
	}

}
