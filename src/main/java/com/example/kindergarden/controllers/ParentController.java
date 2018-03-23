package com.example.kindergarden.controllers;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Parent;
import com.example.kindergarden.base.Session;
import com.example.kindergarden.services.ServiceParent;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ParentController {
  private FileHandler fileHandler = new FileHandler("parents.txt");
  private ServiceParent serviceParent = new ServiceParent();
  private int index;

  @GetMapping("/parentList")
  public String parent(Model model) {
    if (ServiceSession.isSomeoneLoggedIn()) {
      model.addAttribute("niveau", ServiceSession.getCurrentSession().getUserNiveau());
      model.addAttribute("user", ServiceSession.getEmployeeDataForCurrentUser());
      model.addAttribute("parents", serviceParent.getParents());
      if (serviceParent.getParents().size() != 0)
        model.addAttribute("parentDetails", serviceParent.getParents().get(index));
      else
        model.addAttribute("parentDetails", new Parent());
      model.addAttribute("createParent", new Parent());
      model.addAttribute("newSession", new Session());

      return "parentList";
    } else {
      return "redirect:/";
    }
  }

  @PostMapping("createParent")
  public String create(@ModelAttribute Parent parent) {
    serviceParent.addParent(parent);
    return "redirect:/parentList";
  }

  @PostMapping("deleteParent")
  public String delete(@RequestParam int id) {
    serviceParent.deleteParent(id);
    index = 0;
    return "redirect:/parentList";
  }

  @PostMapping("editParent")
  public String edit(@ModelAttribute Parent parent) {
    serviceParent.editParent(parent);
    return "redirect:/parentList";
  }

  @PostMapping("parentDetails")
  public String details(@RequestParam int id) {
    index = serviceParent.getIndexByID(id);
    return "redirect:/parentList";
  }
}
