package com.example.kindergarden.controllers;

import com.example.kindergarden.base.Schedule;
import com.example.kindergarden.services.ServiceCalendar;
import com.example.kindergarden.services.ServiceSession;
import com.example.kindergarden.services.ServiceSchedule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SchedulerController {
    private ServiceCalendar serviceCalendar = new ServiceCalendar();
    private ServiceSchedule serviceSchedule = new ServiceSchedule();
    private Schedule lastestDelete;

    String successMessage = "";

    @GetMapping("/index")
    public String index(Model model) {
        if(ServiceSession.isSomeoneLoggedIn()) {
            model.addAttribute("monthAndYear_TXT", serviceCalendar.getMonthAndYear());
            model.addAttribute("daysInThisMonth", serviceCalendar.getDaysInThisMonth());
            model.addAttribute("days", serviceCalendar.getDays());
            model.addAttribute("today", serviceCalendar.getToday());
            model.addAttribute("dateArray", serviceCalendar.getDateArray());
            model.addAttribute("daysToAdd", serviceCalendar.daysToBypass());
            model.addAttribute("schedules", serviceSchedule.getSchedules(serviceCalendar.getMonthAsString(), serviceCalendar.getYearAsString()));
            model.addAttribute("schedulesPerDay", serviceSchedule.getCountSchedulesPerDay(serviceCalendar));
            model.addAttribute("toIndex", serviceSchedule.getToIndexArray(serviceCalendar));
            model.addAttribute("employees", serviceSchedule.getEmployees());
            model.addAttribute("success_TXT", successMessage);
            successMessage = "";
            return "index";
        } else {
            return "redirect:/";
        }
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

    @PostMapping(value = "/index", params = "go_to=Gå til idag")
    public String goToToday() {
        serviceCalendar.goToToday();
        return "redirect:/index";
    }

    @PostMapping(value = "/index", params = "saveNewSchedule=Opret")
    public String createNewSchedule(@RequestParam("fromTime") String fromTime, @RequestParam("toTime") String toTime, @RequestParam("date") String date ,@RequestParam("employee") int employeeKey) {
        lastestDelete = new Schedule(date, fromTime, toTime, employeeKey);
        serviceSchedule.add(new Schedule(date, fromTime, toTime, employeeKey));
        successMessage = "Den nye vagt er blevet tilføjet og gemt. Kalenderen er opdateret!";
        return "redirect:/index";
    }
}
