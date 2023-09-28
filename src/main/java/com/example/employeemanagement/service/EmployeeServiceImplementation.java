package com.example.employeemanagement.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.pojo.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepositry;

    @Override
    public Employee getEmployee(Long employeeId) {
        Optional<Employee> wrappedOptional = employeeRepositry.findById(employeeId);
        Employee unwrappedEmployee = unwrapEmployee(wrappedOptional, employeeId);
        return unwrappedEmployee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = (List<Employee>) employeeRepositry.findAll();
        return employees;

    }

    @Override
    public String registerEmployee(Employee employee) {
        employeeRepositry.save(employee);
        return "Success";
    }

    public Employee unwrapEmployee(Optional<Employee> wrappedEmployee, Long employeeId) {
        if (wrappedEmployee.isPresent()) {
            return wrappedEmployee.get();
        } else {
            return null;
        }
    }

}
