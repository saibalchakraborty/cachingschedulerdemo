package com.example.caching.democaching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.caching.democaching.model.Employee;
import com.example.caching.democaching.repository.EmployeeRepository;
import com.example.caching.democaching.util.EmployeeUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeUtil employeeUtil;

	public Employee addEmployee(Employee employee) {
		log.info("Adding employee in DB : {}", employee);
		Employee persistedEmployee = employeeRepository.save(employee);
		log.info("Saved employee in DB : {}", persistedEmployee);
		return persistedEmployee;
	}
	
	public List<Employee> allEmployees(){
		List<Employee> allEmployees = employeeRepository.findAll();
		log.info("All employees in DB : {}", allEmployees);
		return allEmployees;
	}

	public List<Employee> loyalEmployees() {
		List<Employee> loyalEmployees = employeeUtil.loyalEmployees();
		log.info("All loyalEmployees in DB : {}", loyalEmployees);
		return loyalEmployees;
	}
}
