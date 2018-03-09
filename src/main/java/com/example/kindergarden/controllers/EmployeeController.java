package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.FileHandler;
import com.example.kindergarden.services.ServiceEmployee;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
  ServiceEmployee serviceEmployee = new ServiceEmployee();

  @GetMapping("/employee")
  public String employee(Model model) {

    if (ServiceSession.isSomeoneLoggedIn()) {
      model.addAttribute("employees", serviceEmployee.getEmployees()); //får fat i arraylist
      model.addAttribute("employee", new Employee());

      return "employee";

    } else {
      return "redirect:/";
    }
  }

  @PostMapping("/employee")
  public String addEmployee(@ModelAttribute Employee em) {
    serviceEmployee.addEmployeeToList(em); //Metode i serviceEmployee der gemmer employee til arraylist
    return "redirect:/employee";
  }

  @PostMapping("/deleteEmployee")
//  @ResponseStatus(value = HttpStatus.OK)
  public void deleteEmployee(@RequestParam int id) {
    serviceEmployee.deleteEmployee(id);
    //return "redirect:/employee";
  }

  @PostMapping("/editEmployee")
  public String editEmployee(@ModelAttribute Employee em) {
    serviceEmployee.editEmployee(em);
    return "redirect:/employee";
  }

  @PostMapping("/details")
  public void details(@RequestParam int id, Model model) {
    int index = serviceEmployee.getIndex(id);
    model.addAttribute("employee", serviceEmployee.getEmployees().get(index));
  }
}
