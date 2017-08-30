package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcgtp.domain.User;
import com.tcgtp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository repository;
	private EncryptionService encryptionService;
	 
    @Autowired
    public void setRoleRepository(UserRepository userRepository) {
        this.repository = userRepository;
    }
    
    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }
	
	@Override
	public List<User> listAll() {
		List<User> userList = new ArrayList<>();
		repository.findAll().forEach(userList::add);
		return userList;
	}

	@Override
	public User getById(Long userID) {
		return repository.findOne(userID);
	}

	@Override
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public User saveOrUpdate(User user) {
		if(user.getPassword() != null){
			user.setEncryptedPassword(encryptionService.encryptString(user.getPassword()));
        }
        return repository.save(user);
    }

	@Override
	@Transactional
	public void delete(Long userID) {
		repository.delete(userID);
		
	}

}
