package com.example.kindergarden.controllers;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Child;
import com.example.kindergarden.base.Parent;
import com.example.kindergarden.services.ServiceChild;
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
    int index;

    @GetMapping("/children")
    public String member(Model model){
        ArrayList<Parent> parents = new ArrayList<>();
        parents.add(new Parent());
        parents.add(new Parent());

        ParentWrapper parentWrapper = new ParentWrapper();
        parentWrapper.setParents(parents);

        if(ServiceSession.isSomeoneLoggedIn()) {
            model.addAttribute("children", serviceChild.getChildren());
            model.addAttribute("child", new Child());
            model.addAttribute("parentWrapper", parentWrapper);
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
    public String addMember(@ModelAttribute Child me, @ModelAttribute ParentWrapper parentWrapper){
        //Saves member to arraylist
        //serviceChild.addChildToList(me);
        System.out.println(Arrays.toString(parentWrapper.getParents().toArray()));
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
