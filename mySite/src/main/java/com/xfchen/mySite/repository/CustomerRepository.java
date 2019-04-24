package com.xfchen.mySite.repository;

import org.springframework.data.repository.CrudRepository;

import com.xfchen.mySite.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long>{
	
	//Customer findByName(String name);
	Customer findById(long id);
}
