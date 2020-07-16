package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.dao.CustomerRepo;
import com.spring.demo.model.Customer;

@RestController
public class CutomerController {

	@Autowired
	CustomerRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping(path="/customer", consumes="application/json")//it will accept json data only
	public Customer addCustomer(@RequestBody Customer customer) {		//to enable raw data input we have to use @RequestBody annotaion
		repo.save(customer);
		return customer;
	}

	@RequestMapping(path="/customers", produces="application/json")	// it will produce json only
	@ResponseBody
	public List<Customer> getCustomers() {		
		return repo.findAll();
	}
	
	@GetMapping("/customer/{id}")
	@ResponseBody 		//if we are using @RestController than we dont need to define @ResponseBody
	public Optional<Customer> getCustomer(@PathVariable("id") int aid) {		
		return repo.findById(aid);
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		Customer c= repo.getOne(id);
		repo.delete(c);
		return "DELETED";
	}
	
	@PutMapping("/customer")
	public Customer updateOrSaveCustomer(@RequestBody Customer customer) {		//to enable raw data input we have to use @RequestBody annotaion
		repo.save(customer);
		return customer;
	}
	
}
