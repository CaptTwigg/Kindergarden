package com.example.kindergarden.controllers;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Child;
import com.example.kindergarden.base.Parent;
import com.example.kindergarden.base.Session;
import com.example.kindergarden.services.ServiceChild;
import com.example.kindergarden.services.ServiceParent;
import com.example.kindergarden.services.ServiceSession;
import com.example.kindergarden.wrappers.ParentWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Controller
public class ChildController {
    ServiceChild serviceChild = new ServiceChild();
    ServiceParent serviceParent = new ServiceParent();
    int index;

    @GetMapping("/children")
    public String member(Model model){
        if(ServiceSession.isSomeoneLoggedIn()) {
            model.addAttribute("children", serviceChild.getChildren());
            model.addAttribute("child", new Child());
            model.addAttribute("parents", new ParentWrapper());
            model.addAttribute("user", ServiceSession.getEmployeeDataForCurrentUser());
            model.addAttribute("details", (serviceChild.getChildren().size() > 0 ? serviceChild.getChildren().get(index) : new Child()));
            model.addAttribute("sessionUserName", ServiceSession.getCurrentSession().getUserName());
            model.addAttribute("newSession",new Session());
            return "children";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/children")
    public String addChild(@ModelAttribute Child me, @ModelAttribute ParentWrapper parentWrapper){
        serviceChild.addChildToList(me, serviceParent.saveParents(parentWrapper.getParents()));
        return "redirect:/children";
    }

    //delete member
    @PostMapping("/deleteChild")
    public String deleteMember(@RequestParam int id) {
        serviceChild.deleteChild(id);
        return "redirect:/children";
    }

    //Edit a specific child
    @PostMapping(value = "/children", params = "saveChild=Gem")
    public String editChild(@ModelAttribute Child ch){
        serviceChild.editChild(ch);
        return "redirect:/children";
    }

    //Show details for a specific member
    @PostMapping("/detailsChild")
    public String details(@RequestParam int id) {
        index = serviceChild.getIndex(id);
        return "redirect:/children";
    }
}
