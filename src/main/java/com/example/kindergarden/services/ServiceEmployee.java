package com.example.kindergarden.services;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceEmployee {
    private ArrayList<Employee> employees = new ArrayList<>();
    public FileHandler fileHandler;

    public ServiceEmployee() {
        try {
            fileHandler = new FileHandler("employees.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEmployeeToList(Employee em){
      int id = employees.size() == 0 ? 1 : getHighestIdOfEmployees()+1;
      employees.add(em.setId(id));
      fileHandler.saveEmployeeToFile(employees);
    }

    public ArrayList<Employee> getEmployees() {
        return employees = fileHandler.loadEmployees("employees.txt");
    }

    private int getHighestIdOfEmployees() {
        int id = 1;

        for(Employee employee: employees) {
            if(employee.getId() > id) {
                id = employee.getId();
            }
        }

        return id;
    }
}
