package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Session;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionController {
    @GetMapping("/")
    public String login(){
        ServiceSession.getSessions().add(new Session("Bjarne", "123456"));

        if(ServiceSession.isSomeoneLoggedIn()) {
            return "redirect:/index";
        } else {
            return "login";
        }
    }

    @PostMapping(value = "/", params = "submit=Log ind")
    public String postLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        ServiceSession.setLogin(username, password);
        return "redirect:/index";
    }

    @GetMapping("/logud")
    public String logud() {
        ServiceSession.logOut();
        return "redirect:/";
    }
}
