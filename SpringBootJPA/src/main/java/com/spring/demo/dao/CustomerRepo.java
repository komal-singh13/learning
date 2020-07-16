package com.spring.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	
}
