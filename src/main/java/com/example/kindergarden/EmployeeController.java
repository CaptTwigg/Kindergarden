package com.example.kindergarden;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

  private Employee employee = new Employee();

  @GetMapping("/employee")
  public String employee(Model model){
    FileHandler fileHandler = new FileHandler();
    fileHandler.addEmplyees();
    model.addAttribute("employee", fileHandler.getEmployees());
    return "employee";
  }

  @PostMapping("/employee")
  public String addEmployee(){
    employee.addEmployeeToList();
    return "redirect:/employee";
  }
}
