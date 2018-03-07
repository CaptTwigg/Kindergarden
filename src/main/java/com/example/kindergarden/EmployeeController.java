package com.example.kindergarden;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
  public FileHandler fileHandler = new FileHandler();
  public ServiceEmployee serviceEmployee = new ServiceEmployee();
  private Employee employee = new Employee();

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
