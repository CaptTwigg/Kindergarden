package com.example.kindergarden;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SchedulerController {

    @GetMapping("/")
    public String index() {
        return "/";
    }
}
