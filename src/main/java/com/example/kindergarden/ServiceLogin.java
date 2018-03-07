package com.example.kindergarden;

import java.util.ArrayList;

public class ServiceLogin {
    ArrayList<Login> logins = new ArrayList<>();

    public void newUser(String userName, String passWord){
        logins.add(new Login(userName, passWord));
    }

    public boolean validateUser(Login login){
        for(int i = 0; i < logins.size(); i++){
            return login.getUserName().equalsIgnoreCase(logins.get(i).getUserName()) && login.getPassWord().equals(logins.get(i).getPassWord());
        }
        return false;
    }
}
