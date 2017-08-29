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
	
	private RoleRepository roleRepository;
	@Autowired
    public void setUserRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

	@Override
	public List<Role> listAll() {
		List<Role> roleList = new ArrayList<>();
		roleRepository.findAll().forEach(roleList::add);
		return roleList;
	}

	@Override
	public Role getById(Long roleID) {
		return roleRepository.findOne(roleID);
	}

	@Override
	public Role saveOrUpdate(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void delete(Long id) {
		roleRepository.delete(id);
	}

}