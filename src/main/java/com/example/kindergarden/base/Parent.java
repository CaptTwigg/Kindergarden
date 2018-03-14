package com.example.kindergarden.base;

import java.io.Serializable;

public class Parent {
  private int id;
  private String name;
  private int phone;
  private String email;

  public Parent(){

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return id+" "+name+" "+phone+" "+email;
  }
}
