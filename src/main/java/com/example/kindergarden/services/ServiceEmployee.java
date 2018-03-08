package com.example.kindergarden.services;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceEmployee {
    private static ArrayList<Employee> employees = new ArrayList<>();
    public FileHandler fileHandler;

    public ServiceEmployee() {
        try {
            fileHandler = new FileHandler("employees.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEmployeeToList(Employee em){
        employees.add(em.setId(employees.size()+1));
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
}
