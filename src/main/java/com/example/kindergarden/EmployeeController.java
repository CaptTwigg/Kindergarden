package com.example.kindergarden;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

  private Employee employee = new Employee();

  @GetMapping("/employee")
  public String employee(){
    return "employee";
  }

  @PostMapping("/employee")
  public String addEmployee(){
    employee.addEmployeeToList();
    return "redirect:/employee";
  }
}
