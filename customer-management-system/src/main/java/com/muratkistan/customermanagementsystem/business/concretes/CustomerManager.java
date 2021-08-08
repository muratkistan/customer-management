package com.muratkistan.customermanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkistan.customermanagementsystem.business.abstracts.CustomerService;
import com.muratkistan.customermanagementsystem.dataAccess.abstracts.CustomerDao;
import com.muratkistan.customermanagementsystem.entity.Customer;

@Service
public class CustomerManager implements CustomerService{
	
	private CustomerDao customerDao;
	

	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}


	@Override
	public List<Customer> getAllCustomers() {
	
		return (List<Customer>)customerDao.findAll();
	}


	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerDao.save(customer);
	}


	@Override
	public Customer updateCustomer(Customer customer) {
		
		return customerDao.save(customer);
	}


	@Override
	public Customer getCustomerById(Long id) {
		
		return customerDao.findById(id).get();
	}


	@Override
	public void deleteCustomerById(Long id) {
		customerDao.deleteById(id);
		
	}
	

}
