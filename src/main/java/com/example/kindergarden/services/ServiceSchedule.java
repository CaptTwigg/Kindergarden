package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Employee;
import com.example.kindergarden.base.Schedule;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ServiceSchedule {
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private FileHandler fileHandler;
    private int[] countSchedulesPerDay = new int[42];
    private int[] countSchedulesPerDayForPerson = new int[42];
    private int[] toIndexArray = new int[42];
    private String[] employeesNames;

    public ServiceSchedule() {
        try {
            fileHandler = new FileHandler("schedules.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Schedule> getSchedules(String month, String year, int id) {
        return schedules = fileHandler.getSchedules(month, year, id);
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

    public int[] getGetCountSchedulesPerDayForPerson(ServiceCalendar serviceCalendar, int id) {
        if(id != 0){
            resetCountPerPerson();

            for(int i = 0; i < countSchedulesPerDayForPerson.length; i++) {
                for(Schedule schedule: schedules) {
                    if(Integer.parseInt(schedule.getDate()) == i+1 && schedule.getEmployeeKey() == id) {
                        countSchedulesPerDayForPerson[i+serviceCalendar.getPreviousMonthDays()]++;
                    }
                }
            }
        }

        return countSchedulesPerDayForPerson;
    }

    private void resetCountPerPerson() {
        for(int i = 0; i < countSchedulesPerDayForPerson.length; i++) {
            countSchedulesPerDayForPerson[i] = 0;
        }
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

        return toIndexArray;
    }

    private void resetAllSchedules() {
        for(int i = 0; i < countSchedulesPerDay.length; i++) {
            countSchedulesPerDay[i] = toIndexArray[i] = 0;
        }
    }

    public void add(Schedule schedule) {
        schedules = fileHandler.getAllSchedules();
        schedules.add(schedule.setId(getHighestId()));
        Collections.sort(schedules);
        fileHandler.saveSchedulesToFile(schedules);
    }

    private int getHighestId() {
        int highestId = 00;

        for(Schedule schedule: schedules) {
            if(schedule.getId() > highestId) {
                highestId = schedule.getId();
            }
        }

        return (highestId == 0 ? 1 : highestId + 1);
    }

    public Schedule remove(int ID) {
        Schedule removedSchedule = new Schedule();

        schedules = fileHandler.getAllSchedules();

        for(Schedule schedule: schedules) {
            if(schedule.getId() == ID) {
                schedules.remove(schedule);
                removedSchedule = schedule;
                break;
            }
        }

        Collections.sort(schedules);
        fileHandler.saveSchedulesToFile(schedules);

        return removedSchedule;
    }
}
