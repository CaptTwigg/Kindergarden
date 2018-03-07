package com.example.kindergarden;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    ServiceLogin serviceLogin = new ServiceLogin();

    @GetMapping("/")
    public String login(Model model){
        serviceLogin.newUser("Bjarne", "Frandsen");
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/")
    public String postLogin(@ModelAttribute Login login){
        System.out.println(serviceLogin.validateUser(login));
        if(serviceLogin.validateUser(login)){
            return "redirect:/index";
        }else{
            return "redirect:/";
        }
    }
}
