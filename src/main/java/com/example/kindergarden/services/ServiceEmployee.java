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

    public static void addEmployeeToList(Employee em){
      int id = employees.size() == 0 ? 1 : employees.get(employees.size()).getId()+1;
      employees.add(em.setId(id));
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
}
