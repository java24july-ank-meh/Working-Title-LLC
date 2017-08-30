package com.tcgtp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tcgtp.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
