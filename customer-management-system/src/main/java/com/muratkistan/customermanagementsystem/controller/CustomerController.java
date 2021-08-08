package com.muratkistan.customermanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.muratkistan.customermanagementsystem.business.abstracts.CustomerService;
import com.muratkistan.customermanagementsystem.entity.Customer;

@Controller
public class CustomerController {
	
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public String getCustomers(Model model ) {
		model.addAttribute("customers",customerService.getAllCustomers());
		return "customers";
	}
	
	@GetMapping("/customers/add")
	public String addCustomerPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add_customer";
		
	}
	
	@PostMapping("/customers")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/customers";
		
	}
	
	@GetMapping("/customers/update/{id}")
	public String updateCustomerPage(@PathVariable Long id, Model model ) {
		model.addAttribute("customer", customerService.getCustomerById(id));
		return "update_customer";
	}
	
	@PostMapping("/customers/{id}")
	public String updateCustomer(@PathVariable Long id, @ModelAttribute("customer") Customer customer,Model model) {
		
		Customer oldCustomer = customerService.getCustomerById(id);
		
		oldCustomer.setId(id);
		oldCustomer.setFirstName(customer.getFirstName());
		oldCustomer.setLastName(customer.getLastName());
		oldCustomer.setEmail(customer.getEmail());
		oldCustomer.setPhoneNumber(customer.getPhoneNumber());
		oldCustomer.setAddress(customer.getAddress());
		
		customerService.updateCustomer(oldCustomer);
		return "redirect:/customers";
		
		
	}
	
	@GetMapping("/customers/delete/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomerById(id);
		return "redirect:/customers";
		
	}
	
	
	
	
	
	
}
