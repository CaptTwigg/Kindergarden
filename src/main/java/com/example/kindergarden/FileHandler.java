package com.example.kindergarden;

import com.example.kindergarden.base.Employee;
import com.example.kindergarden.base.Schedule;
import com.example.kindergarden.services.ServiceEmployee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private String fileName;
    private Scanner scanner;
    private String employeeFile = "./src/main/resources/files/";

    public FileHandler(String fileName) {
        this.fileName = fileName;
        try {
            scanner = new Scanner(new File("./src/main/resources/files/"+fileName)).useDelimiter(";");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveEmployeeToFile(){
      ServiceEmployee serviceEmployee = new ServiceEmployee();
        for (Employee employeeSave: serviceEmployee.getEmployees()){
            PrintStream newEmployeeInfo = null;
            try {
                newEmployeeInfo = new PrintStream(new FileOutputStream("./src/main/resources/files/"+fileName,true));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String employeeInfo = String.format("%s;%s;%s;%s;%s;%s;%s;%s\n",
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

    public String getFileName() {
        return fileName;
    }

    public FileHandler setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public ArrayList<Schedule> getSchedules(String month, String year)  {
        ArrayList<Schedule> schedules = new ArrayList<>();

        try {
            scanner = new Scanner(new File("./src/main/resources/files/" + fileName)).useDelimiter(";");

            while (scanner.hasNextLine()) {
                int ID = scanner.nextInt();
                String date = scanner.next();
                String fromTime = scanner.next();
                String toTime = scanner.next();
                int employeeKey = scanner.nextInt();

                if (Integer.parseInt(date.substring(0, 6)) == Integer.parseInt(year + month)) {
                    schedules.add(new Schedule(ID, date, fromTime, toTime, employeeKey));
                }

                scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return schedules;
    }
}