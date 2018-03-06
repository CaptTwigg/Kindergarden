package com.example.kindergarden;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SchedulerController {

    private ServiceCalendar serviceCalendar = new ServiceCalendar();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("monthAndYear_TXT", serviceCalendar.getMonthAndYear());
        model.addAttribute("daysInThisMonth", serviceCalendar.getDaysInThisMonth());
        model.addAttribute("days", serviceCalendar.getDays());
        return "index";
    }

    @PostMapping(value = "/", params = "month_chooser=Forrige")
    public String goToPreviousMonth() {
        serviceCalendar.decrement();
        return "redirect:/";
    }

    @PostMapping(value = "/", params = "month_chooser=Næste")
    public String goToNextMonth() {
        serviceCalendar.increment();
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
