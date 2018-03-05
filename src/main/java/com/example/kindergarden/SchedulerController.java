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
    int[] days = new int[42];
    int counter = 0;

    @GetMapping("/")
    public String index(Model model) {
        //Forrige måned
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Calendar prevCal = calendar;

        prevCal.add(Calendar.DAY_OF_MONTH, -(calendar.get(Calendar.DAY_OF_WEEK)-2));

        for(int i = 0; i < calendar.get(Calendar.DAY_OF_WEEK)-1; i++) {
            days[counter] = prevCal.get(Calendar.DAY_OF_MONTH);
            prevCal.add(Calendar.DAY_OF_MONTH, 1);
            counter++;
        }

        //Nuværende måned
        for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            days[counter] = i;
            counter++;
        }

        //Næste måned
        for(int i = 1; i < (counter-days.length); i++) {
            days[counter] = i;
            counter++;
        }

        System.out.println(Arrays.toString(days));


        model.addAttribute("monthAndYear_TXT", String.valueOf(months[calendar.get(Calendar.MONTH)]+" "+calendar.get(Calendar.YEAR)));
        model.addAttribute("days", days);
        System.out.println(String.valueOf(months[calendar.get(Calendar.MONTH)]+" "+calendar.get(Calendar.YEAR)));
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
