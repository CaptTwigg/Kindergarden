package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Schedule;

import java.util.ArrayList;

public class ServiceSchedule {
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private FileHandler fileHandler;

    public ServiceSchedule() {
        try {
            fileHandler = new FileHandler("schedules.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Schedule> getSchedules(String month, String year) {
        return fileHandler.getSchedules(month, year);
    }
}
