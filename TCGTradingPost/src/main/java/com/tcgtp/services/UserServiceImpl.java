package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tcgtp.domain.User;
import com.tcgtp.repositories.UserRepository;

public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	private EncryptionService encryptionService;
	 
    @Autowired
    public void setRoleRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }
	
	@Override
	public List<User> listAll() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return userList;
	}

	@Override
	public User getById(Long userID) {
		return userRepository.findOne(userID);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User saveOrUpdate(User user) {
		if(user.getPassword() != null){
			user.setEncryptedPassword(encryptionService.encryptString(user.getPassword()));
        }
        return userRepository.save(user);
    }

	@Override
	@Transactional
	public void delete(Long userID) {
		userRepository.delete(userID);
		
	}

}
