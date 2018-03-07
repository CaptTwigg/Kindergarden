package com.example.kindergarden;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private String fileName;
    private Scanner scanner;
    private ArrayList<Employee> employees = new ArrayList<>();

    public FileHandler(){

    }

    public FileHandler(String fileName) throws Exception {
        this.fileName = fileName;
        scanner = new Scanner(new File("./resources/"+fileName));
    }

    public void addEmplyees(){

        /*try{
            Scanner read = new Scanner(new File("Employees.txt"));
            while(read.hasNextLine()){
                String line = read.nextLine();
                employees.add(new Employee(line));
            }
        }catch(FileNotFoundException e){
            System.out.println("Filen blev ikke fundet");
        }*/

        employees.add(new Employee("Mette", "Hansen"));
        employees.add(new Employee("Bjarne", "Frandsen"));
        employees.add(new Employee("Frederik", "Nielsen"));
        employees.add(new Employee("Monica", "Rasmussen"));
    }


    public String getFileName() {
        return fileName;
    }

    public FileHandler setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public ArrayList<Employee> getEmployees(){
        return employees;
    }
}
