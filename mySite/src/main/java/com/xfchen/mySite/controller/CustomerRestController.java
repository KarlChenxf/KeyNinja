package com.xfchen.mySite.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfchen.mySite.domain.Customer;
import com.xfchen.mySite.service.CustomerService;

@RestController
@RequestMapping("/list")
public class CustomerRestController{
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
		
	@RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
    public List<Customer> getCustomerList() {
		return customerService.findAll();
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.findById(id);
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT, produces = "application/json")
    public List<Customer> updateCustomer(@RequestParam Map<String, String> customer, @PathVariable Long id) {
        Customer updateCustomer =  customerService.findById(id);
        updateCustomer.setFirstName(customer.get("firstName"));
        updateCustomer.setLastName(customer.get("lastName"));
        updateCustomer.setEmail(customer.get("email"));
        customerService.save(updateCustomer);
        return customerService.findAll();
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST, produces = "application/json")
    public List<Customer> saveCustomer(@RequestParam Map<String, String> customer) {
		Customer newCustomer = new Customer();
		newCustomer.setFirstName(customer.get("firstName"));
		newCustomer.setLastName(customer.get("lastName"));
		newCustomer.setEmail(customer.get("email"));
		customerService.save(newCustomer);
		return customerService.findAll();
    }
	
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public List<Customer> deleteCustomer(@PathVariable Long id) {
    	customerService.delete(customerService.findById(id));
    	return customerService.findAll();        
    }
 

 
    
}