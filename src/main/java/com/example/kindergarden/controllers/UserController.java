package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.services.ServiceEmployee;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
  private ServiceEmployee serviceEmployee = new ServiceEmployee();
  private ServiceSession serviceSession = new ServiceSession();

  @PostMapping(value="/saveUserInfo")
  public String saveUserInfo(@RequestParam String path, @ModelAttribute Employee employee){
    System.out.println(employee);
    System.out.println(ServiceSession.getCurrentSession().getUserKey());

    employee.setId(ServiceSession.getCurrentSession().getUserKey());
    employee.setNiveau(ServiceSession.getCurrentSession().getUserNiveau());
    System.out.println(employee.getId());
    System.out.println(employee.getNiveau());

    System.out.println(employee);

    serviceEmployee.editEmployee(employee);
    return "redirect:"+path;
  }
}
