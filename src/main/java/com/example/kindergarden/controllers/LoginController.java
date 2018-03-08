package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Login;
import com.example.kindergarden.services.ServiceLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/")
    public String login(){
        ServiceLogin.getLogins().add(new Login("Bjarne", "123456"));

        if(ServiceLogin.isSomeoneLoggedIn()) {
            return "redirect:/index";
        } else {
            return "login";
        }
    }

    @PostMapping(value = "/", params = "submit=Log ind")
    public String postLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        ServiceLogin.setLogin(username, password);
        return "redirect:/index";
    }
}
