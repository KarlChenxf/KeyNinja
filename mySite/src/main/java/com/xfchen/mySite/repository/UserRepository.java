package com.xfchen.mySite.repository;

import org.springframework.data.repository.CrudRepository;

import com.xfchen.mySite.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);//spring will know pass username field in user

	User findByEmail(String email);
}
