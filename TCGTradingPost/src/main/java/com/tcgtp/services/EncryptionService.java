package com.tcgtp.services;

public interface EncryptionService {
	
    String encryptString(String str);
    
    boolean checkPassword(String inputPassword, String encryptedPassword);
}