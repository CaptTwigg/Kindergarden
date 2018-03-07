package com.example.kindergarden.controllers;

import com.example.kindergarden.services.ServiceCalendar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SchedulerController {

    private ServiceCalendar serviceCalendar = new ServiceCalendar();

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("monthAndYear_TXT", serviceCalendar.getMonthAndYear());
        model.addAttribute("daysInThisMonth", serviceCalendar.getDaysInThisMonth());
        model.addAttribute("days", serviceCalendar.getDays());
        model.addAttribute("today", serviceCalendar.getToday());
        model.addAttribute("dateArray", serviceCalendar.getDateArray());
        model.addAttribute("daysToAdd", serviceCalendar.daysToBypass());
        return "index";
    }

    @PostMapping(value = "/index", params = "month_chooser=Forrige")
    public String goToPreviousMonth() {
        serviceCalendar.decrement();
        return "redirect:/index";
    }

    @PostMapping(value = "/index", params = "month_chooser=Næste")
    public String goToNextMonth() {
        serviceCalendar.increment();
        return "redirect:/index";
    }
}
