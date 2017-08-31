package com.tcgtp.services;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {
	
<<<<<<< HEAD
	StrongPasswordEncryptor passwordEncryptor;
	@Autowired
	public void setStrongPasswordEncryptor(StrongPasswordEncryptor passwordEncryptor) {
		this.passwordEncryptor = passwordEncryptor;
=======
	StrongPasswordEncryptor strongPasswordEncryptor;
	@Autowired
	public void setStrongPasswordEncryptor(StrongPasswordEncryptor strongPasswordEncryptor) {
		this.strongPasswordEncryptor = strongPasswordEncryptor;
>>>>>>> master
	}

	
	public String encryptString(String str) {
<<<<<<< HEAD
		return passwordEncryptor.encryptPassword(str);
=======
		return strongPasswordEncryptor.encryptPassword(str);
>>>>>>> master
	}

	
	public boolean checkPassword(String plainPassword, String encryptedPassword) {
<<<<<<< HEAD
		return passwordEncryptor.checkPassword(plainPassword, encryptedPassword);
=======
		return strongPasswordEncryptor.checkPassword(plainPassword, encryptedPassword);
>>>>>>> master
	}

}
