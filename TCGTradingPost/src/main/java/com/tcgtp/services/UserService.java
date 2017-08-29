package com.tcgtp.services;

import com.tcgtp.domain.User;

public interface UserService {
	
	public User getUserById(Long userID);
	
	public User getUserByUsername(String username);
	
	public User saveUser(User user);
}
