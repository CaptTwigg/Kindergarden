package com.example.kindergarden;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private String fileName;
    private Scanner scanner;
    ArrayList<Employee> employees = new ArrayList<>();

    public FileHandler(String fileName) throws Exception {
        this.fileName = fileName;
        scanner = new Scanner(new File("./resources/"+fileName));
    }


    /*public ArrayList<Employee> getEmployees(){
        employees.add(new Employee(Janni, Jensen));

        return employees;
    }*/


    public String getFileName() {
        return fileName;
    }

    public FileHandler setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
