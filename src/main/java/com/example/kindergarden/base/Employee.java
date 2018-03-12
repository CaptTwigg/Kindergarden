package com.example.kindergarden.base;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Employee {
    private int id;
    private String username;
    private String password;

  private String firstName;

  private String lastName;
  private String roadName;
  private int roadNumber;
  private String city;
  private int postalCode;
  private int phoneNumber;
  private String email;
    public Employee(){

    }

    public Employee(String line) {
      String[] employee = line.split(";");
      this.id = Integer.parseInt(employee[0]);
      this.username = employee[1];
      this.password = employee[2];
      this.firstName = employee[3];
      this.lastName = employee[4];
      this.roadName = employee[5];
      this.roadNumber = Integer.parseInt(employee[6]);
      this.city = employee[7];
      this.postalCode = Integer.parseInt(employee[8]);
      this.phoneNumber = Integer.parseInt(employee[9]);
      this.email = employee[10];
    }

    public Employee(int id, String firstName, String lastName, String roadName, int roadNumber, String city, int postalCode, int phoneNumber, String email) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.roadName = roadName;
      this.roadNumber = roadNumber;
      this.city = city;
      this.postalCode = postalCode;
      this.phoneNumber = phoneNumber;
      this.email = email;
    }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", roadName='" + roadName + '\'' +
        ", roadNumber=" + roadNumber +
        ", city='" + city + '\'' +
        ", postalCode=" + postalCode +
        ", phoneNumber=" + phoneNumber +
        ", email='" + email + '\'' +
        '}';
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRoadName() {
      return roadName;
    }

    public void setRoadName(String roadName) {
      this.roadName = roadName;
    }

    public int getRoadNumber() {
      return roadNumber;
    }

    public void setRoadNumber(int roadNumber) {
      this.roadNumber = roadNumber;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public int getPostalCode() {
      return postalCode;
    }

    public void setPostalCode(int postalCode) {
      this.postalCode = postalCode;
    }

    public int getPhoneNumber() {
      return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
      this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getFirstName() {
          return firstName;
      }

    public void setFirstName(String firstName) {
          this.firstName = firstName;
      }

    public String getLastName() {
          return lastName;
      }

    public void setLastName(String lastName) {
          this.lastName = lastName;
      }

    public int getId() {
      return id;
    }

    public Employee setId(int id) {
      this.id = id;
      return this;
    }
}
