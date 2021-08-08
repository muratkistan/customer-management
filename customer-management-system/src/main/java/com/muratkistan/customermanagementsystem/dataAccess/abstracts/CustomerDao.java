package com.muratkistan.customermanagementsystem.dataAccess.abstracts;

import org.springframework.data.repository.CrudRepository;

import com.muratkistan.customermanagementsystem.entity.Customer;

public interface CustomerDao extends CrudRepository<Customer, Long> {

}
