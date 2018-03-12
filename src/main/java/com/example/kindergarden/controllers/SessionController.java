package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Session;
import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionController {
    ServiceSession serviceSession = new ServiceSession();
    String message = "";

    @GetMapping("/")
    public String login(Model model){
        if(ServiceSession.isSomeoneLoggedIn()) {
            return "redirect:/index";
        } else {
            model.addAttribute("message", message);
            message = "";
            return "login";
        }
    }

    @PostMapping(value = "/", params = "submit=Log ind")
    public String postLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        if(serviceSession.checkLogin(username, password)) {
            return "redirect:/index";
        } else {
            message = "Ugyldigt brugernavn eller password";
            return "redirect:/";
        }
    }

    @GetMapping("/logud")
    public String logud() {
        ServiceSession.logOut();
        return "redirect:/";
    }
}
