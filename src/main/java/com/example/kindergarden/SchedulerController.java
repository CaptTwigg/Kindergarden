package com.example.kindergarden;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.*;

@Controller
public class SchedulerController {
    Calendar calendar = new GregorianCalendar(TimeZone.getDefault(), new Locale("dk", "DK"));
    int today = calendar.get(Calendar.DATE);
    String[] months = {"Januar", "Februar", "Marts", "April", "Maj", "Juni", "Juli", "August", "September", "Oktober", "November", "December"};


    @GetMapping("/")
    public String index(Model model) {
        int[] days = new int[42];
        int counter = 0;

        /*--- Forrige måned ---*/
        //Sætter datoen til den første i måneden
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        //Regner ud hvor mange dage der skal udskrives af den forrige måned
        int weekdays = (calendar.get(Calendar.DAY_OF_WEEK) == 1 ? 6 : calendar.get(Calendar.DAY_OF_WEEK)-2);

        //Trækker dage fra kalenderen
        calendar.add(Calendar.DAY_OF_MONTH, -weekdays);

        for(int i = 0; i < weekdays; i++) {
            days[counter] = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.add(Calendar.DATE, 1);
            counter++;
        }

        //Nuværende måned
        for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            days[counter] = i;
            counter++;
        }

        //Næste måned
        for(int i = 1; counter < days.length; i++) {
            days[counter] = i;
            counter++;
        }

        model.addAttribute("monthAndYear_TXT", String.valueOf(months[calendar.get(Calendar.MONTH)]+" "+calendar.get(Calendar.YEAR)));
        model.addAttribute("days", days);
        return "index";
    }

    @PostMapping(value = "/", params = "month_chooser=Forrige")
    public String goToPreviousMonth() {
        calendar.add(Calendar.MONTH, -1);
        return "redirect:/";
    }

    @PostMapping(value = "/", params = "month_chooser=Næste")
    public String goToNextMonth() {
        calendar.add(Calendar.MONTH, 1);
        return "redirect:/";
    }
}
