package com.xfchen.mySite.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xfchen.mySite.domain.Customer;
import com.xfchen.mySite.repository.CustomerRepository;
import com.xfchen.mySite.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = (List<Customer>) customerRepository.findAll();
		Collections.sort(customerList, new Comparator<Customer>() {
    		@Override
    		public int compare(Customer c1,Customer c2) {
    			return (int)(c1.getId() - c2.getId());
    		}
    	});
		return customerList;
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.delete(customer);
	}

	@Override
	public Customer findById(long id) {
		return customerRepository.findById(id);
	}
	

	
	

}
