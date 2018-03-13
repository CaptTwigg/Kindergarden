package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Member;
import com.example.kindergarden.services.ServiceMember;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
    ServiceMember serviceMember = new ServiceMember();
    int index;

    @GetMapping("/member")
    public String member(Model model){
        if(ServiceSession.isSomeoneLoggedIn()) {
        //Gets arraylist with members
            model.addAttribute("members", serviceMember.getMembers());
            model.addAttribute("member", new Member());
            model.addAttribute("details", serviceMember.getMembers().get(index));
            return "member";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/member")
    public String addMember(@ModelAttribute Member me){
        //Saves member to arraylist
        serviceMember.addMemberToList(me);
        return "redirect:/member";
    }

    //deletes members
    @PostMapping("/deleteMember")
    public String deleteMember(@RequestParam int id) {
        serviceMember.deleteMember(id);
        return "redirect:/member";
    }

    //Edit a specific member
    @PostMapping(value = "/member", params = "saveMember=Gem")
    public String editMember(@ModelAttribute Member me){
        serviceMember.editMember(me);
        return "redirect:/member";
    }

    //Show details for a specific member
    /*@PostMapping("/details")
    public String details(@RequestParam int id) {
        index = serviceMember.getIndex(id);
        return "redirect:/member";
    }*/
}
