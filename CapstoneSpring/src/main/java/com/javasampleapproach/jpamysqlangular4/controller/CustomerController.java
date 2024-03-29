package com.javasampleapproach.jpamysqlangular4.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jpamysqlangular4.model.Customer;
import com.javasampleapproach.jpamysqlangular4.repo.CustomerRepository;

@RestController //@controller+@responsebody
public class CustomerController {

	@Autowired
	CustomerRepository repository;

	@GetMapping(value="/customer",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAll() {
		List<Customer> list = new ArrayList<>();
		Iterable<Customer> customers = repository.findAll(); // this is because the crud repository returns Iterable
		customers.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/postcustomer")
	public Customer postCustomer(@RequestBody Customer customer) {

		repository.save(new Customer(customer.getFirstName(),
				   customer.getLastName(),
				   customer.getEmail(),
				   customer.getUsername(),
				   customer.getPassword(),
				   customer.getAccount_type(),
				   customer.getTelephone_no(),
				   customer.getAddress(),
                   customer.getCity(),
			       customer.getState(),
			       customer.getZip()));
		 
		return customer;
	}
	
	@GetMapping(value="/login/{username}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer findByUsername(@PathVariable String username) {
		System.out.println(username.trim());
		System.out.println(username.trim());
		Customer customers = repository.findByUsername(username.trim());
		if(customers!=null)
		{	
		return customers;	
		}
		else 
		{
			Customer customer= new Customer("wrong","wrong","wrong@gmail.com",
					"wrong","wrong","wrong",
		            "wrong","wrong","wrong","wrong","wrong");
			return customer;
		}
	} 

	@GetMapping(value="/findbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findByLastName(@PathVariable String lastName) {

		List<Customer> customers = repository.findByLastName(lastName);
		return customers;
	}
	
	@DeleteMapping(value="/customer/{id}")
	public void deleteCustomer(@PathVariable long id){
		
		repository.delete(id);
	}
}
