package com.example.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.employeemanagement.pojo.Employee;
import com.example.employeemanagement.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @PostMapping("/register")
    public String registerEmployee(@Valid Employee employee, BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "form";
        }
        employeeService.registerEmployee(employee);
        System.out.println(employeeService.getEmployee(Long.valueOf(1)));
        return "redirect:/employee/database";
    }

    @GetMapping("/database")
    public String getDatabase(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employeeDatabase";
    }

}
