package com.example.kindergarden.base;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String roadName;
    private String city;
    private int postalCode;
    private int phoneNumber;
    private String email;
    private int niveau;

    public Employee(){
    }

    public Employee(String line) {
      String[] employee = line.split(";");
      this.id = Integer.parseInt(employee[0]);
      this.firstName = employee[1];
      this.lastName = employee[2];
      this.roadName = employee[3];
      this.city = employee[4];
      this.postalCode = Integer.parseInt(employee[5]);
      this.phoneNumber = Integer.parseInt(employee[6]);
      this.email = employee[7];
      this.niveau = Integer.parseInt(employee[8]);
    }

  public int getNiveau() {
    return niveau;
  }

  public void setNiveau(int niveau) {
    this.niveau = niveau;
  }

  public String getRoadName() {
      return roadName;
    }

    public void setRoadName(String roadName) {
      this.roadName = roadName;
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
