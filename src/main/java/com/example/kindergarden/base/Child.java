package com.example.kindergarden.base;

import java.io.Serializable;

public class Child implements Serializable {
  private int id;
  private String firstName;
  private String lastName;
  Parent[] parents;

  public Child() {

  }

  public Child(int id, String firstName, String lastName, Parent[] parents) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.parents = parents;
  }


  @Override
  public String toString() {
    return "Child{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", Parents=" + parents;
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

  public Parent[] getParents() {
    return parents;
  }

  public void setParents(Parent[] parents) {
    this.parents = parents;
  }
}
