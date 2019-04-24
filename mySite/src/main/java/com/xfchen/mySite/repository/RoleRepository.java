package com.xfchen.mySite.repository;

import org.springframework.data.repository.CrudRepository;

import com.xfchen.mySite.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByName(String name);
	

}
