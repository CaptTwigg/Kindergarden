package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.base.Session;
import com.example.kindergarden.services.ServiceEmployee;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class EmployeeController {
  ServiceEmployee serviceEmployee = new ServiceEmployee();
  int index;

  private String successMessage = "";

  @GetMapping("/employee")
  public String employee(Model model) {
    if (ServiceSession.isSomeoneLoggedIn()) {
      model.addAttribute("employees", serviceEmployee.getEmployees()); //får fat i arraylist
      model.addAttribute("employee", new Employee());
      model.addAttribute("details", serviceEmployee.getEmployees().get(index));
      model.addAttribute("niveau", ServiceSession.getCurrentSession().getUserNiveau());
      model.addAttribute("session", new Session());
      model.addAttribute("user", ServiceSession.getEmployeeDataForCurrentUser());
      model.addAttribute("success_TXT", successMessage);
      successMessage = "";
      return "employee";
    } else {
      return "redirect:/";
    }
  }

  @PostMapping("/employee")
  public String addEmployee(@ModelAttribute Employee em, @ModelAttribute Session session) {
    serviceEmployee.addEmployeeToList(em, session); //Metode i serviceEmployee der gemmer employee til arraylist
    successMessage = "Medarbejderen blev tilføjet til systemet.";
    return "redirect:/employee";
  }

  //Sletter en medarbejder
  @PostMapping("/deleteEmployee")
  public String deleteEmployee(@RequestParam int id) {
    serviceEmployee.deleteEmployee(id);
    index = serviceEmployee.getEmployees().size()-1;
    successMessage = "Medarbejderen blev slettet";
    return "redirect:/employee";
  }

  //Gemmer ny medarbejder
  @PostMapping(value = "/employee", params = "saveEditEmployee=Gem")
  public String editEmployee(@ModelAttribute Employee em){
    serviceEmployee.editEmployee(em);
    successMessage = "Medarbejderen blev opdateret.";
    return "redirect:/employee";
  }

  //Viser detaljer for personen.
  @PostMapping("/details")
  public String details(@RequestParam int id) {
    index = serviceEmployee.getIndex(id);
    return "redirect:/employee";
  }
}
