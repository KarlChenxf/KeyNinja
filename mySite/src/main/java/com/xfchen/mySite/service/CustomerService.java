package com.xfchen.mySite.service;

import java.util.List;

import com.xfchen.mySite.domain.Customer;

public interface CustomerService {
	void delete(Customer customer);
	
	Customer save(Customer customer);
	
	List<Customer> findAll();
	
	Customer findById(long id);

}
