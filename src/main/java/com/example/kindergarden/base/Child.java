package com.example.kindergarden.base;

import java.io.Serializable;

public class Child implements Serializable {
  private int id;
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private int postalCode;
  private String birthDay;
  private boolean isOnWaitinglist;
  private int parentKeyOne;
  private int parentKeyTwo;

  public Child() {}

  public Child(int id, String firstName, String lastName, String address, String city, int postalCode, String birthDay, boolean isOnWaitinglist, int parentKeyOne, int parentKeyTwo) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.postalCode = postalCode;
    this.birthDay = birthDay;
    this.isOnWaitinglist = isOnWaitinglist;
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
        ", birthDay='" + birthDay + '\'' +
        ", isOnWaitinglist=" + isOnWaitinglist +
        ", parentKeyOne=" + parentKeyOne +
        ", parentKeyTwo=" + parentKeyTwo +
        '}';
  }

  public int getId() {
    return id;
  }

  public Child setId(int id) {
    this.id = id;
    return this;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(String birthDay) {
    this.birthDay = birthDay;
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

  public boolean isOnWaitinglist() {
        return isOnWaitinglist;
  }

  public void setOnWaitinglist(boolean onWaitinglist) {
      isOnWaitinglist = onWaitinglist;
  }

  public int getParentKeyOne() {
    return parentKeyOne;
  }

  public Child setParentKeyOne(int parentKeyOne) {
    this.parentKeyOne = parentKeyOne;
    return this;
  }

  public int getParentKeyTwo() {
    return parentKeyTwo;
  }

  public Child setParentKeyTwo(int parentKeyTwo) {
    this.parentKeyTwo = parentKeyTwo;
    return this;
  }
}
