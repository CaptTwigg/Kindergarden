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

  public void addEmployeeToList(Employee em) {
    int id = employees.size() == 0 ? 1 : getHighestIdOfEmployees() + 1;
    employees.add(em.setId(id));
    fileHandler.saveEmployeeToFile(employees);
  }

  public ArrayList<Employee> getEmployees() {
    return employees = fileHandler.loadEmployees("employees.txt");
  }

  private int getHighestIdOfEmployees() {
    int id = 1;

    for (Employee employee : employees) {
      if (employee.getId() > id) {
        id = employee.getId();
      }
    }

    return id;
  }

  public void deleteEmployee(int id) {
    int index = getIndex(id);

    if (index > -1) {
      employees.remove(index);
      System.out.println("Removed");
      fileHandler.saveEmployeeToFile(employees);
    } else System.out.println("not found");
  }

  public void editEmployee(Employee employee){
    int index = getIndex(employee.getId());

    employees.set(index,employee);
    employees.remove(index +1);

  }

  public int getIndex(int id) {
    for (int i = 0; i < employees.size(); i++)
      if (employees.get(i).getId() == id)
        return i;

    return -1;
  }

  public static void main(String[] args) {
    ServiceEmployee se = new ServiceEmployee();
    System.out.println(se.getEmployees());
    se.deleteEmployee(1);
    System.out.println(se.getEmployees());

  }


}