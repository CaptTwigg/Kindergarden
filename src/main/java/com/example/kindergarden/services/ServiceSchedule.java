package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Employee;
import com.example.kindergarden.base.Schedule;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ServiceSchedule {
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private FileHandler fileHandler;
    private int[] countSchedulesPerDay = new int[42];
    private int[] toIndexArray = new int[42];
    private String[] employeesNames;

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

    public ArrayList<Employee> getEmployees() {
        return employees = fileHandler.loadEmployees("employees.txt");
    }


    public int[] getCountSchedulesPerDay(ServiceCalendar serviceCalendar) {
        resetAllSchedules();

        for(int i = 0; i < countSchedulesPerDay.length; i++) {
           for(Schedule schedule: schedules) {
                if(Integer.parseInt(schedule.getDate()) == i+1) {
                    countSchedulesPerDay[i+serviceCalendar.getPreviousMonthDays()]++;
                }
           }
        }

        return countSchedulesPerDay;
    }

    public int[] getToIndexArray(ServiceCalendar serviceCalendar) {
        int cumulative = 0;
        int daysFromPrevMonth = serviceCalendar.getPreviousMonthDays();
        int prevIndex = 0;

        for(int i = 0; i < toIndexArray.length; i++) {
            int thisIndex = 0;
            int count = 1;

            for (Schedule schedule : schedules) {
                if (Integer.parseInt(schedule.getDate()) + 1 == (i - daysFromPrevMonth + 2) && count != 3) {
                    thisIndex++;
                    count++;
                }else if (Integer.parseInt(schedule.getDate()) + 1 > (i - daysFromPrevMonth + 2)) {
                    break;
                }
            }

            toIndexArray[i] = (thisIndex == 0 ? 0 : thisIndex +prevIndex + cumulative);
            cumulative += prevIndex;

            prevIndex = 0;

            for (Schedule schedule : schedules) {
                if (Integer.parseInt(schedule.getDate()) + 1 == (i - daysFromPrevMonth + 2)) {
                    prevIndex++;
                }
            }
        }

        System.out.println(Arrays.toString(toIndexArray));
        return toIndexArray;
    }

    private void resetAllSchedules() {
        for(int i = 0; i < countSchedulesPerDay.length; i++) {
            countSchedulesPerDay[i] = 0;
        }

        for(int i = 0; i < toIndexArray.length; i++) {
            toIndexArray[i] = 0;
        }
    }
}
