package com.example.employeemanagement.service;

import java.util.List;

import com.example.employeemanagement.pojo.Employee;

public interface EmployeeService {

    Employee getEmployee(Long employeeId);

    String registerEmployee(Employee employee);

    List<Employee> getEmployees();
}
