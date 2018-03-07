package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Schedule;
import com.example.kindergarden.services.ServiceCalendar;
import com.example.kindergarden.services.ServiceSchedule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class SchedulerController {
    private ServiceCalendar serviceCalendar = new ServiceCalendar();
    private ServiceSchedule serviceSchedule = new ServiceSchedule();

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("monthAndYear_TXT", serviceCalendar.getMonthAndYear());
        model.addAttribute("daysInThisMonth", serviceCalendar.getDaysInThisMonth());
        model.addAttribute("days", serviceCalendar.getDays());
        model.addAttribute("today", serviceCalendar.getToday());
        model.addAttribute("dateArray", serviceCalendar.getDateArray());
        model.addAttribute("daysToAdd", serviceCalendar.daysToBypass());
        model.addAttribute("schedules", serviceSchedule.getSchedules(serviceCalendar.getMonthAsString(), serviceCalendar.getYearAsString()));
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
