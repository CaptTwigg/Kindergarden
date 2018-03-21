package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Employee;
import com.example.kindergarden.base.Session;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;

public class ServiceSession {
    private static Session session = null;


    private static FileHandler fileHandler;

    public ServiceSession(){
        fileHandler = new FileHandler("logins.txt");
    }

    public static boolean isSomeoneLoggedIn() {
        return session != null;
    }

    public boolean checkLogin(String username, String password) {
        if(fileHandler.checkLogin(username, md5Hasher(password))) {
            session = fileHandler.getLogin(username, md5Hasher(password));
            return true;
        } else {
            return false;
        }
    }

    public static void saveLogin(Session session, int id, ArrayList<Employee> employees){
        session.setUserKey(id);
        session.setPassWord(md5Hasher(session.getPassWord()));
        fileHandler.saveLoginInfo(session, employees);
    }

   /* public static boolean comparePassword(Session session){
        for(Session tempSession: fileHandler.loadSessions()){
            if(tempSession.getUserKey() == session.getUserKey()){
                if(tempSession.getPassWord().equals(md5Hasher(session.getPassWord()))){
                    System.out.println("kage");
                    return true;
                }
            }
        }
        return false;
    }*/

    //hasher password
    private static String md5Hasher(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

    public static Session getCurrentSession() {
        return session;
    }

    public static void logOut() {
        session = null;
    }

    public static void deleteLogin(int id) {
        fileHandler.setFileName("logins.txt").deleteLogin(id);
    }

    public static boolean checkUsername(String username) {
        return fileHandler.setFileName("logins.txt").checkUsername(username);
    }

    public static Employee getEmployeeDataForCurrentUser() {
        ArrayList<Employee> employees = new ServiceEmployee().getEmployees();
        Employee employeeForUser = null;

        for(Employee employee: employees) {
            if(employee.getId() == ServiceSession.getCurrentSession().getUserKey()) {
                employeeForUser = employee;
                break;
            }
        }
        return employeeForUser;
    }


  public static boolean checkPassword(String password) {
    return fileHandler.setFileName("logins.txt").checkPassword(md5Hasher(password));
  }
}
