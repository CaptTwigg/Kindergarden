package com.example.kindergarden.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WaitingListController {
    @GetMapping("/waitingList")
    public String waitingList(){
        return "waitingList";
    }
}
