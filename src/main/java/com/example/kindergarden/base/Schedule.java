package com.example.kindergarden.base;

public class Schedule {
    private int Id;
    private String date;
    private String fromTime;
    private String toTime;
    private int employeeKey;

    public Schedule(int id, String date, String fromTime, String toTime, int employeeKey) {
        Id = id;
        this.date = date.substring(6, 8);
        this.fromTime = fromTime.substring(0,2)+":"+fromTime.substring(2,4);
        this.toTime = toTime.substring(0,2)+":"+toTime.substring(2,4);
        this.employeeKey = employeeKey;
    }

    public int getId() {
        return Id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public int getEmployeeKey() {
        return employeeKey;
    }

    public void setEmployeeKey(int employeeKey) {
        this.employeeKey = employeeKey;
    }
}
