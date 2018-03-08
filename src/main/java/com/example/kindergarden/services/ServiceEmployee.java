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

    public void loadEmpolyees(){
        try{
            Scanner read = new Scanner(new File(fileHandler.getFileName()));
            while(read.hasNextLine()){
                String line = read.nextLine();
                employees.add(new Employee(line)); //tilføj parameterne
            }
        }catch(FileNotFoundException e){
            System.out.println("Filen blev ikke fundet");
        }
    }

    public void addEmployeeToList(Employee em){
        employees.add(em);
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
}
