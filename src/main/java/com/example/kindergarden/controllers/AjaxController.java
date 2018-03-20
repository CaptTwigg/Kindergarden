package com.example.kindergarden.controllers;

import com.example.kindergarden.services.ServiceSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AjaxController {

    @PostMapping("/checkUsername")
    @ResponseBody
    public boolean check(@RequestParam("username") String username) {
        return ServiceSession.checkUsername(username);
    }

    @PostMapping("/checkPassword")
    @ResponseBody
    public boolean checkPassword(@RequestParam("password") String password) {
        return ServiceSession.checkPassword(password);
    }
}
