package com.tcgtp.services;

import java.util.List;

import com.tcgtp.domain.User;

public interface UserService {
	
	public List<User> listAll();
	
	public User getById(Long userID);
 
	public User saveOrUpdate(User domainObject);
 
    public void delete(Long userID);
	
	public User findByUsername(String username);
}
