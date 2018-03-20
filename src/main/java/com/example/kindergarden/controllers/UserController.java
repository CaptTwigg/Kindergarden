package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.base.Session;
import com.example.kindergarden.services.ServiceEmployee;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
  private ServiceEmployee serviceEmployee = new ServiceEmployee();

  @PostMapping(value="/saveUserInfo")
  public String saveUserInfo(@RequestParam String path, @ModelAttribute Employee employee){
    serviceEmployee.editEmployee(employee);
    return "redirect:"+path;
  }

  @PostMapping(value="/savePassWord")
  public String editPassword(@RequestParam String path, @ModelAttribute Session session){
    System.out.println(session);
    if(ServiceSession.comparePassword(session)){
      if(ServiceSession.repeatPassword(session)){
        System.out.println(session.getPassWord());
        ServiceSession.getCurrentSession().setPassWord(session.getNewPassWord());
        ServiceSession.saveNewPassword(session.getUserKey(),session.getUserName(),session.getPassWord(), session.getUserNiveau());
        System.out.println(ServiceSession.getCurrentSession().getNewPassWord());
      }
    }else System.out.println("forkert");
    return "redirect:"+path;
  }
}
