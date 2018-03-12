package com.example.kindergarden;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.base.Schedule;
import com.example.kindergarden.base.Session;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private String fileName;
    private Scanner scanner;
    private String path = "./src/main/resources/files/";

    public FileHandler(String fileName) {
        this.fileName = fileName;
        try {
            scanner = new Scanner(new File(path+fileName)).useDelimiter(";");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public FileHandler setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public ArrayList<Employee> loadEmployees(String fileName){
      ArrayList<Employee> employees = new ArrayList<>();
        try {
          Scanner read = new Scanner(new File(path + fileName));
          while (read.hasNextLine()) {
            String line = read.nextLine();
            employees.add(new Employee(line));
          }
        } catch (FileNotFoundException e) {
          System.out.println("Filen blev ikke fundet");
        }

        return employees;
    }

    public void saveEmployeeToFile(ArrayList<Employee> employees){
      try {
        new PrintStream(new File(path+fileName));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

        PrintStream newEmployeeInfo = null;

        for (Employee employeeSave: employees){
            try {
                newEmployeeInfo = new PrintStream(new FileOutputStream(path+fileName, true));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String employeeInfo = String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;\n",
              employeeSave.getId(),
              employeeSave.getFirstName(),
              employeeSave.getLastName(),
              employeeSave.getRoadName(),
              employeeSave.getRoadNumber(),
              employeeSave.getCity(),
              employeeSave.getPostalCode(),
              employeeSave.getPhoneNumber(),
              employeeSave.getEmail());

          newEmployeeInfo.print(employeeInfo);
          System.out.print("\n");
        }
    }

    /*public void saveLoginToFile(ArrayList<Login> logins){
      try {
        new PrintStream(new File(path+fileName));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      PrintStream newLoginInfo = null;

      for (Login loginSave: logins){
        try {
          newLoginInfo = new PrintStream(new FileOutputStream("./src/main/resources/files/"+fileName, true));
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        String loginInfo = String.format("%s;%s;\n",
            loginSave.getUsername(),
            loginSave.getPassword());

        newLoginInfo.print(loginInfo);
        System.out.print("\n");
      }
    }*/

    public boolean checkLogin(String username, String password) {
        try {
            scanner = new Scanner(new File(path + fileName)).useDelimiter(";");

            while (scanner.hasNextLine()) {
                int ID = scanner.nextInt();
                String userNameTemp = scanner.next();
                String passWordTemp = scanner.next();

                if(userNameTemp.equals(username) && passWordTemp.equals(password)){
                    return true;
                }

                scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Session getLogion(String username, String password) {
        Session session = null;

        try {
            scanner = new Scanner(new File(path+ fileName)).useDelimiter(";");

            while (scanner.hasNextLine()) {
                int ID = scanner.nextInt();
                String userNameTemp = scanner.next();
                String passWordTemp = scanner.next();
                int niveau = scanner.nextInt();

                if(userNameTemp.equals(username) && passWordTemp.equals(password)){
                    session = new Session(userNameTemp, passWordTemp, ID, niveau);
                    break;
                }

                scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return session;
    }

    public ArrayList<Schedule> getSchedules(String month, String year, int id)  {
        ArrayList<Schedule> schedules = new ArrayList<>();
        ArrayList<Employee> tempEmployees = loadEmployees("employees.txt");

        try {
            scanner = new Scanner(new File(path + fileName)).useDelimiter(";");

            while (scanner.hasNextLine()) {
                int ID = scanner.nextInt();
                String date = scanner.next();
                String fromTime = scanner.next();
                String toTime = scanner.next();
                int employeeKey = scanner.nextInt();

                if(Integer.parseInt(month)==0 && Integer.parseInt(year)==0){
                        if(id == employeeKey) {
                            schedules.add(new Schedule(ID, date, fromTime, toTime, employeeKey));
                        }

                } else if (Integer.parseInt(date.substring(0, 6)) == Integer.parseInt(year + month)) {
                    for(Employee employee: tempEmployees) {
                        if(employee.getId() == employeeKey && id == 0) {
                            schedules.add(new Schedule(ID, date, fromTime, toTime, employee.getFirstName(), employeeKey, employee.getFirstName()+" "+employee.getLastName()));
                        } else if(employee.getId() == employeeKey && id == employeeKey) {
                            schedules.add(new Schedule(ID, date, fromTime, toTime, employee.getFirstName(), employeeKey, employee.getFirstName()+" "+employee.getLastName()));
                        }
                    }
                }

                scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return schedules;
    }

    public void saveSchedulesToFile(ArrayList<Schedule> schedules){
        try {
            new PrintStream(new File(path+fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PrintStream newScheduleInfo = null;

        for (Schedule schedule: schedules){
            try {
                newScheduleInfo = new PrintStream(new FileOutputStream(path+fileName, true));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String employeeInfo = String.format("%s;%s;%s;%s;%s;\n",
                    schedule.getId(),
                    schedule.getDate(),
                    schedule.getFromTime(),
                    schedule.getToTime(),
                    schedule.getEmployeeKey());

            newScheduleInfo.print(employeeInfo);
        }
    }

    public ArrayList<Schedule> getAllSchedules() {
        ArrayList<Schedule> schedules = new ArrayList<>();

        try {
            scanner = new Scanner(new File(path + fileName)).useDelimiter(";");

            while (scanner.hasNextLine()) {
                schedules.add(new Schedule(scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt()));
                scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return schedules;
    }
}