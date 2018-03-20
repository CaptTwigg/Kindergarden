package com.example.kindergarden.base;

public class Parent {
  private int id;
  private String name;
  private int phone;
  private String email;
  private boolean gender;

  public Parent(){

  }

  public Parent(int id, String name, int phone, String email, boolean gender) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.gender = gender;
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

  public boolean isGender() {
    return gender;
  }

  public void setGender(boolean gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return String.format("id: %s name: %s phone: %s email: %s gender: %s "
      , this.id, this.name, this.phone, this.email, this.gender);
  }
}
