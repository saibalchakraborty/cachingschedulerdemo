package com.example.caching.democaching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.caching.democaching.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
