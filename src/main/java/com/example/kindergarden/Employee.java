package com.example.kindergarden;

public class Employee {
    private String firstName;
    private String lastName;

    /*public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }*/

  public void addEmployeeToList(){
    System.out.println("kom ind");
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
}
