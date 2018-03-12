package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;

import com.example.kindergarden.base.Login;

import java.util.ArrayList;

public class ServiceLogin {
  private ArrayList<Login> logins = new ArrayList<>();
  public FileHandler fileHandler;

  public ServiceLogin(){
    try {
      fileHandler = new FileHandler("logins.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void addLoginToList(Login log){
    logins.add(log);
    fileHandler.saveLoginToFile(logins);
  }
}
