package com.tcgtp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.tcgtp.domain.Role;
import com.tcgtp.repositories.RoleRepository;
import com.tcgtp.repositories.UserRepository;

@Service
@Profile("springdatajpa")
public class RoleServiceImpl implements RoleService {
	
	private RoleRepository repository;
	@Autowired
    public void setUserRepository(RoleRepository roleRepository) {
        this.repository = roleRepository;
    }

	@Override
	public List<Role> listAll() {
		List<Role> roleList = new ArrayList<>();
		repository.findAll().forEach(roleList::add);
		return roleList;
	}

	@Override
	public Role getById(Long roleID) {
		return repository.findOne(roleID);
	}

	@Override
	public Role saveOrUpdate(Role role) {
		return repository.save(role);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

}