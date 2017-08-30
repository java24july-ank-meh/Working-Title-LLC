package com.tcgtp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tcgtp.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
