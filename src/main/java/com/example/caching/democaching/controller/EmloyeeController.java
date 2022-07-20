package com.example.caching.democaching.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.caching.democaching.model.Employee;
import com.example.caching.democaching.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1")
@Slf4j
public class EmloyeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String printHello() {
		log.info("<-In hello end point->");
		return "Hello World!";
	}
	
	@PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		log.info("<-In addEmployee end point->");
		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> allEmployees(){
		log.info("<-In getEmployees end point->");
		List<Employee> allEmployees = employeeService.allEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getLoyalEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getLoyalEmployees(){
		log.info("<-In getLoyalEmployees end point->");
		List<Employee> allEmployees = employeeService.loyalEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}
}
