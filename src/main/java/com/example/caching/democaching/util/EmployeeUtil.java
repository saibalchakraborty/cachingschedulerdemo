package com.example.caching.democaching.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;

import com.example.caching.democaching.model.Employee;
import com.example.caching.democaching.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class EmployeeUtil {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Cacheable(value = "loyalEmployees")
	public List<Employee> loyalEmployees(){
		log.info("Executing method, not picking cached result!");
		List<Employee> loyalEmployees = employeeRepository.findAll();
		log.info("All available employee at begining : {}", loyalEmployees);
		return loyalEmployees;
	}
}
