package com.example.employeemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.employeemanagement.pojo.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
