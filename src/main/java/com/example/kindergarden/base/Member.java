package com.example.kindergarden.base;

public class Member {
    private int id;
    private String firstName;
    private String lastName;
    private String roadName;
    private int roadNumber;
    private String city;
    private int postalCode;
    private int phoneNumber;
    private String email;

    public Member() {

    }

    //
    public Member(int id, String firstName, String lastName, String roadName, int roadNumber, String city, int postalCode, int phoneNumber, String email) {
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

    //Read from file
    public Member(String line) {
        String[] member = line.split(";");
        this.id = Integer.parseInt(member[0]);
        this.firstName = member[1];
        this.lastName = member[2];
        this.roadName = member[3];
        this.roadNumber = Integer.parseInt(member[4]);
        this.city = member[5];
        this.postalCode = Integer.parseInt(member[6]);
        this.phoneNumber = Integer.parseInt(member[7]);
        this.email = member[8];
    }

    @Override
    public String toString() {
        return "Member{" +
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
    public int getId() {
        return id;
    }

    public Member setId(int id) {
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
}
