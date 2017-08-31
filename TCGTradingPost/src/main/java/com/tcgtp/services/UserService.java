package com.tcgtp.services;

import java.util.List;

import com.tcgtp.domain.User;

public interface UserService {
	
	public List<User> listAll();
	
	public User getById(Long userID);
 
<<<<<<< HEAD
	public User saveOrUpdate(User domainObject);
=======
	public User saveOrUpdate(User user);
>>>>>>> master
 
    public void delete(Long userID);
	
	public User findByUsername(String username);
}
