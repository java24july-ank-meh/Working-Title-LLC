package com.tcgtp.services;

import java.util.List;

import com.tcgtp.domain.Role;

public interface RoleService {
	
	public List<Role> listAll();
	
	public Role getById(Long roleID);
	
	public Role saveOrUpdate(Role role);

	public void delete(Long id);
	
	

}
