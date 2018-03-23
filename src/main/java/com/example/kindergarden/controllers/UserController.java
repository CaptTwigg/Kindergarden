package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.base.Session;
import com.example.kindergarden.services.ServiceEmployee;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
  private ServiceEmployee serviceEmployee = new ServiceEmployee();

  @PostMapping(value="/saveUserInfo")
  public String saveUserInfo(@RequestParam String path, @ModelAttribute Employee employee, Model model){
    serviceEmployee.editEmployee(employee);
    SchedulerController.successMessage = "Dine nye oplysninger er blevet gemt!";
    EmployeeController.successMessage = "Dine nye oplysninger er blevet gemt!";
    ChildController.successMessage = "Dine nye oplysninger er blevet gemt!";
    return "redirect:"+path;
  }

  @PostMapping(value="/savePassWord")
  public String editPassword(@RequestParam String path, @ModelAttribute Session session, @RequestParam String newPasswordCheck){
    ServiceSession.editPassword(session, newPasswordCheck);
    SchedulerController.successMessage = "Dit password er blevet ændret og gemt!";
    EmployeeController.successMessage = "Dit password er blevet ændret og gemt!";
    ChildController.successMessage = "Dit password er blevet ændret og gemt!";
    return "redirect:"+path;
  }
}
