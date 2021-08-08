package com.muratkistan.customermanagementsystem.business.abstracts;

import java.util.List;

import com.muratkistan.customermanagementsystem.entity.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	
	Customer addCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	void deleteCustomerById(Long id);
	
	Customer getCustomerById(Long id);
	
	

}
