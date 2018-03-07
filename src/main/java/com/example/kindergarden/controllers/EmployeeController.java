package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.FileHandler;
import com.example.kindergarden.services.ServiceEmployee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    public ServiceEmployee serviceEmployee = new ServiceEmployee();

    @GetMapping("/employee")
    public String employee(Model model){
        model.addAttribute("employee", serviceEmployee.getEmployees());
        return "employee";
    }

    @PostMapping("/employee")
    public String addEmployee(@ModelAttribute Employee em){
        em.addEmployeeToList();
        return "redirect:/employee";
    }
}
