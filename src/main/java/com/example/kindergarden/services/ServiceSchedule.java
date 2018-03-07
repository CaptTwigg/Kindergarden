package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Schedule;

import java.util.ArrayList;
import java.util.Arrays;

public class ServiceSchedule {
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private FileHandler fileHandler;
    private int[] countSchedulesPerDay = new int[42];

    public ServiceSchedule() {
        try {
            fileHandler = new FileHandler("schedules.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Schedule> getSchedules(String month, String year) {
        return schedules = fileHandler.getSchedules(month, year);
    }

    public int[] getCountSchedulesPerDay(ServiceCalendar serviceCalendar) {
        for(int i = 0; i < countSchedulesPerDay.length; i++) {
           for(Schedule schedule: schedules) {
                if(Integer.parseInt(schedule.getDate()) == i+1) {
                    countSchedulesPerDay[i+serviceCalendar.getPreviousMonthDays()]++;
                }
           }
        }

        System.out.println(Arrays.toString(countSchedulesPerDay));
        return countSchedulesPerDay;
    }
}
