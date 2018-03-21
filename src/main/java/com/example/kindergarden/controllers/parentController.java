package com.example.kindergarden.controllers;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Child;
import com.example.kindergarden.base.Session;
import com.example.kindergarden.services.ServiceSession;
import com.example.kindergarden.wrappers.ParentWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class parentController {
  public FileHandler fileHandler = new FileHandler("parents.txt");

  @GetMapping("/parentList")
  public String parent(Model model){
    if(ServiceSession.isSomeoneLoggedIn()) {
      model.addAttribute("niveau", ServiceSession.getCurrentSession().getUserNiveau());
      model.addAttribute("user", ServiceSession.getEmployeeDataForCurrentUser());
      model.addAttribute("sessionUserName", ServiceSession.getCurrentSession().getUserName());
      model.addAttribute("newSession",new Session());
      model.addAttribute("parents", fileHandler.loadAllParents());
      model.addAttribute("parent", fileHandler.loadAllParents().get(0));
      return "parentList";
    }else{
      return "redirect:/";
    }
  }
}
