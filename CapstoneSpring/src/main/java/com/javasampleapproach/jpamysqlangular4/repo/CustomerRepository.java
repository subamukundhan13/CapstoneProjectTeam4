package com.javasampleapproach.jpamysqlangular4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	//https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
	List<Customer> findByLastName(String lastName);
	Customer findByUsername(String username);
}