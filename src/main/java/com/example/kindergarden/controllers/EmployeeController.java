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
        model.addAttribute("employees", ServiceEmployee.getEmployees()); //får fat i arraylist
        model.addAttribute("employee", new Employee());

        return "employee";
    }

    @PostMapping("/employee")
    public String addEmployee(@ModelAttribute Employee em){
        serviceEmployee.addEmployeeToList(em); //Metode i serviceEmployee der gerne skulle gemme indtastet værdi i en arraylist
        new FileHandler("employees.txt").saveEmployeeToFile();
        //test
        System.out.println(em);

      System.out.println(serviceEmployee.getEmployees());
        return "redirect:/employee";
    }
}
