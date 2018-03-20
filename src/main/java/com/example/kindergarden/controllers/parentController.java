package com.example.kindergarden.controllers;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Child;
import com.example.kindergarden.services.ServiceSession;
import com.example.kindergarden.wrappers.ParentWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class parentController {
  private FileHandler fileHandler = new FileHandler("parents.txt");
  private int index;

  @GetMapping("/parentList")
  public String parent(Model model){
    if(ServiceSession.isSomeoneLoggedIn()) {
      model.addAttribute("niveau", ServiceSession.getCurrentSession().getUserNiveau());
      model.addAttribute("user", ServiceSession.getEmployeeDataForCurrentUser());
      model.addAttribute("parents", fileHandler.loadAllParents());
      model.addAttribute("parent", fileHandler.loadAllParents().get(index));
      return "parentList";
    }else{
      return "redirect:/";
    }
  }

  @PostMapping("parentDetails")
  public String details(@RequestParam int id){
    index = id-1;
    return "redirect:/parentList";
  }
}
