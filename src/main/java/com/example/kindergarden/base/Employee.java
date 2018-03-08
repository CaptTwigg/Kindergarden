package com.example.kindergarden.base;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Employee {
    private int id;
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
      this.firstName = employee[1];
      this.lastName = employee[2];
      this.roadName = employee[3];
      this.roadNumber = Integer.parseInt(employee[4]);
      this.city = employee[5];
      this.postalCode = Integer.parseInt(employee[6]);
      this.phoneNumber = Integer.parseInt(employee[7]);
      this.email = employee[8];
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
