package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.services.ServiceEmployee;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
  ServiceEmployee serviceEmployee = new ServiceEmployee();
  int index;

  @GetMapping("/employee")
  public String employee(Model model) {

    if (ServiceSession.isSomeoneLoggedIn()) {
      model.addAttribute("employees", serviceEmployee.getEmployees()); //får fat i arraylist
      model.addAttribute("employee", new Employee());
      //model.addAttribute("login", new Login());
      model.addAttribute("details", serviceEmployee.getEmployees().get(index)); //

      return "employee";

    } else {
      return "redirect:/";
    }
  }

  @PostMapping("/employee")
  public String addEmployee(@ModelAttribute Employee em) {
    serviceEmployee.addEmployeeToList(em); //Metode i serviceEmployee der gemmer employee til arraylist
    //serviceLogin.addLoginToList(log);
    return "redirect:/employee";
  }

  //Sletter en medarbejder
  @PostMapping("/deleteEmployee")
  public String deleteEmployee(@RequestParam int id) {
    serviceEmployee.deleteEmployee(id);
    return "redirect:/employee";
  }
  //
  @PostMapping(value = "/employee", params = "saveEmployee=Gem")
  public String editEmployee(@ModelAttribute Employee em){
    serviceEmployee.editEmployee(em);
    return "redirect:/employee";
  }

  //Viser detaljer for personen.
  @PostMapping("/details")
  public String details(@RequestParam int id) {
    index = serviceEmployee.getIndex(id);
    return "redirect:/employee";
  }
}
