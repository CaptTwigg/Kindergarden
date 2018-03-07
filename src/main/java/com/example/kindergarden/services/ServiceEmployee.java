package com.example.kindergarden.services;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceEmployee {
  private ArrayList<Employee> employees = new ArrayList<>();

  public FileHandler fileHandler = new FileHandler();

  public void addEmpolyees(){
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

  public ArrayList<Employee> getEmployees() {
    return employees;
  }
}
