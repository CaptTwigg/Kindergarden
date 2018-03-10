package com.example.kindergarden.base;

public class Schedule {
    private int Id;
    private String date;
    private String fromTime;
    private String toTime;
    private int employeeKey;
    private String employeeName;
    private String employeeFullName;

    public Schedule() {}

    public Schedule(int id, String date, String fromTime, String toTime, String employeeName, int employeeKey, String employeeFullName) {
        Id = id;
        this.date = date.substring(6, 8);
        this.fromTime = fromTime.substring(0,2)+":"+fromTime.substring(2,4);
        this.toTime = toTime.substring(0,2)+":"+toTime.substring(2,4);
        this.employeeName = employeeName;
        this.employeeKey = employeeKey;
        this.employeeFullName = employeeFullName;
    }

    //Constructor used for when getting all schedules
    public Schedule(int Id, String date, String fromTime, String toTime, int employeeKey) {
        this.Id = Id;
        this.date = date;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.employeeKey = employeeKey;
    }

    //Constructor used for when saving a new one
    public Schedule(String date, String fromTime, String toTime, int employeeKey) {
        this.date = date.replaceAll(    "-", "");
        this.fromTime = fromTime.replace(":", "");
        this.toTime = toTime.replace(":", "");
        this.employeeKey = employeeKey;
    }

    public Schedule setId(int Id) {
        this.Id = Id;
        return this;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeKey() {
        return employeeKey;
    }

    public void setEmployeeKey(int employeeKey) {
        this.employeeKey = employeeKey;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }
}
