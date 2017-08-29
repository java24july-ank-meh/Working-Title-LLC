package com.tcgtp.services;

import com.tcgtp.domain.User;

public interface UserService extends CRUDService<User> {
	
	public User getUserById(Long userID);
	
	public User findByUsername(String username);
	
	public User saveUser(User user);

	
}
