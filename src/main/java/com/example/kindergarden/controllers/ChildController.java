package com.example.kindergarden.controllers;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Child;
import com.example.kindergarden.base.Parent;
import com.example.kindergarden.services.ServiceChild;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChildController {
    ServiceChild serviceChild = new ServiceChild();
    int index;

    @GetMapping("/children")
    public String member(Model model){
        if(ServiceSession.isSomeoneLoggedIn()) {
            model.addAttribute("children", serviceChild.getChildren());
            model.addAttribute("child", new Child());
            if(serviceChild.getChildren().size() > 0) {
                model.addAttribute("details", serviceChild.getChildren().get(index));
            }else{
                model.addAttribute("details", new Child());
            }
            return "children";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/children")
    public String addMember(@ModelAttribute Child me){
        //Saves member to arraylist
        serviceChild.addChildToList(me);
        return "redirect:/children";
    }

    //delete member
    @PostMapping("/deleteChild")
    public String deleteMember(@RequestParam int id) {
        serviceChild.deleteChild(id);
        return "redirect:/children";
    }

    //Edit a specific member
    @PostMapping(value = "/children", params = "saveMember=Gem")
    public String editMember(@ModelAttribute Child me){
        serviceChild.editChild(me);
        return "redirect:/children";
    }

    //Show details for a specific member
    @PostMapping("/detailsChild")
    public String details(@RequestParam int id) {
        index = serviceChild.getIndex(id);
        return "redirect:/children";
    }
}
