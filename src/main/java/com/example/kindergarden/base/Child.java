package com.example.kindergarden.base;

import java.io.Serializable;

public class Child implements Serializable {
  private int id;
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private int postalCode;
  private String parentNameOne;
  private String parentNameTwo;
  private int phoneNumberOne;
  private int phoneNumberTwo;
  private String emailOne;
  private String emailTwo;

  public Child() {

  }

  public Child(int id, String firstName, String lastName, String address, String city, int postalCode, String parentNameOne, String parentNameTwo, int phoneNumberOne, int phoneNumberTwo, String emailOne, String emailTwo) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.postalCode = postalCode;
    this.parentNameOne = parentNameOne;
    this.parentNameTwo = parentNameTwo;
    this.phoneNumberOne = phoneNumberOne;
    this.phoneNumberTwo = phoneNumberTwo;
    this.emailOne = emailOne;
    this.emailTwo = emailTwo;
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
            ", parentNameOne='" + parentNameOne + '\'' +
            ", parentNameTwo='" + parentNameTwo + '\'' +
            ", phoneNumberOne=" + phoneNumberOne +
            ", phoneNumberTwo=" + phoneNumberTwo +
            ", emailOne='" + emailOne + '\'' +
            ", emailTwo='" + emailTwo + '\'' +
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

  public String getParentNameOne() {
    return parentNameOne;
  }

  public void setParentNameOne(String parentNameOne) {
    this.parentNameOne = parentNameOne;
  }

  public String getParentNameTwo() {
    return parentNameTwo;
  }

  public void setParentNameTwo(String parentNameTwo) {
    this.parentNameTwo = parentNameTwo;
  }

  public int getPhoneNumberOne() {
    return phoneNumberOne;
  }

  public void setPhoneNumberOne(int phoneNumberOne) {
    this.phoneNumberOne = phoneNumberOne;
  }

  public int getPhoneNumberTwo() {
    return phoneNumberTwo;
  }

  public void setPhoneNumberTwo(int phoneNumberTwo) {
    this.phoneNumberTwo = phoneNumberTwo;
  }

  public String getEmailOne() {
    return emailOne;
  }

  public void setEmailOne(String emailOne) {
    this.emailOne = emailOne;
  }

  public String getEmailTwo() {
    return emailTwo;
  }

  public void setEmailTwo(String emailTwo) {
    this.emailTwo = emailTwo;
  }
}
