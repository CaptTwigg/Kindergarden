package com.example.kindergarden.base;

import java.io.Serializable;

public class Child implements Serializable {
  private int id;
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private int postalCode;
  private int parentKeyOne;
  private int parentKeyTwo;

  public Child() {}

  public Child(int id, String firstName, String lastName, String address, String city, int postalCode, int parentKeyOne, int parentKeyTwo) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.postalCode = postalCode;
    this.parentKeyOne = parentKeyOne;
    this.parentKeyTwo = parentKeyTwo;
  }

  @Override
  public String toString() {
    return "Child{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", postalCode=" + postalCode +
            ", parentKeyOne='" + parentKeyOne + '\'' +
            ", parentKeyTwo='" + parentKeyTwo + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public Child setId(int id) {
    this.id = id;
    return this;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  public int getParentKeyOne() {
    return parentKeyOne;
  }

  public void setParentKeyOne(int parentKeyOne) {
    this.parentKeyOne = parentKeyOne;
  }

  public int getParentKeyTwo() {
    return parentKeyTwo;
  }

  public void setParentKeyTwo(int parentKeyTwo) {
    this.parentKeyTwo = parentKeyTwo;
  }
}
