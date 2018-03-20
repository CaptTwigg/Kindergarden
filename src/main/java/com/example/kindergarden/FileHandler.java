package com.example.kindergarden;

import com.example.kindergarden.base.*;
import com.example.kindergarden.services.ServiceEmployee;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

            Scanner readLogins = new Scanner(new File(path+"logins.txt")).useDelimiter(";");
            while(readLogins.hasNextLine()) {
                //If employee id is id in logins, get the right row
                if(readLogins.nextInt() == Integer.parseInt(line.split(";")[0])) {
                    String temp = readLogins.next();
                    temp = readLogins.next();
                    line += readLogins.nextInt();
                }

                readLogins.nextLine();
            }

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
            String employeeInfo = String.format("%s;%s;%s;%s;%s;%s;%s;%s;\n",
              employeeSave.getId(),
              employeeSave.getFirstName(),
              employeeSave.getLastName(),
              employeeSave.getRoadName(),
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
                    session = new Session(ID, userNameTemp, passWordTemp, niveau);
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

    public void deleteLogin(int id) {
        String[] logins = new String[new ServiceEmployee().getEmployees().size()];

        try {
            scanner = new Scanner(new File(path + "logins.txt")).useDelimiter(";");
            int counter = 0;

            while (scanner.hasNextLine()) {
                int tempID = scanner.nextInt();

                if (tempID != id) {
                    logins[counter] = tempID + ";" + scanner.next() + ";" + scanner.next() + ";" + scanner.nextInt() + ";";
                    counter++;
                }

                scanner.nextLine();
            }

            PrintStream printStream = new PrintStream(new FileOutputStream(path + "logins.txt"));

            for (String s : logins) {
                printStream.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveLoginInfo(Session session, ArrayList<Employee> employees) {
        String[] logins = new String[employees.size()];

        try {
            scanner = new Scanner(new File(path + "logins.txt")).useDelimiter(";");
            int counter = 0;

            while (scanner.hasNextLine()) {
                    logins[counter] = scanner.nextInt() + ";" + scanner.next() + ";" + scanner.next() + ";" + scanner.nextInt() + ";";
                    counter++;

                scanner.nextLine();
            }

            PrintStream printStream = new PrintStream(new FileOutputStream(path + "logins.txt"));

            for (String s : logins) {
                printStream.println(s);
            }

            printStream.println(session.getUserKey()+";"+session.getUserName()+";"+session.getPassWord()+";"+session.getUserNiveau()+";");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList loadChildren() {
        ArrayList array = new ArrayList();
        try {
            FileInputStream fileIn = new FileInputStream(path+fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn); //Den konventerer objektet til bytecode og gemmer til fil.
            array = (ArrayList) in.readObject(); //Den læser bytecoden og laver det til et objekt/arraylist.
            in.close();
            fileIn.close();
            System.out.println("Data loaded.");
        } catch (EOFException E) {
            System.out.println("File may be empty -" + E);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }

    public void saveChildren( java.lang.Object object){
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream(path+fileName);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean checkUsername(String username){
        try {
            Scanner readLogins = new Scanner(new File(path+"logins.txt")).useDelimiter(";");
            while(readLogins.hasNextLine()) {
                int id = readLogins.nextInt();
                if(readLogins.next().equals(username)) {
                    return true;
                }

                readLogins.nextLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet");
        }

        return false;
    }

    public void saveParents(List<Parent> parentList) {
        try {
            ArrayList<Parent> parentArrayList = loadAllParents();

            for(Parent parent: parentList) {
                if(parent.getId() != 0) {
                    parentArrayList.add(new Parent(parent.getId(), parent.getName(), parent.getPhone(), parent.getEmail(), parent.isGender()));
                }
            }

            PrintStream saveToFile = new PrintStream(new File(path+"parents.txt"));

            for (Parent parent: parentArrayList){
                try {
                    saveToFile = new PrintStream(new FileOutputStream(path+"parents.txt", true));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                String parentInfo = String.format("%s;%s;%s;%s;\n",
                        parent.getId(),
                        parent.getName(),
                        parent.getPhone(),
                        parent.getEmail());

                saveToFile.print(parentInfo);

                System.out.println(Arrays.toString(parentArrayList.toArray()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Parent> loadAllParents() {
        ArrayList<Parent> parentArrayList = new ArrayList<>();

        try {
            Scanner readParents = new Scanner(new File(path+"parents.txt")).useDelimiter(";");

            while(readParents.hasNextLine()) {
                parentArrayList.add(new Parent(readParents.nextInt(), readParents.next(), readParents.nextInt(), readParents.next(), readParents.nextBoolean()));
                readParents.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parentArrayList;
    }

    public ArrayList<Session> loadSessions(){
        ArrayList<Session> sessions = new ArrayList<>();

            try {
                Scanner readSessions = new Scanner(new File(path+"logins.txt")).useDelimiter(";");

                while(readSessions.hasNextLine()){
                    sessions.add(new Session(readSessions.nextInt(), readSessions.next(), readSessions.next(), readSessions.nextInt()));
                    readSessions.nextLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        return sessions;
    }
}