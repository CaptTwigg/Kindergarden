package com.example.kindergarden.base;

public class Session {
    private String userName;
    private String passWord;
    private int userKey;
    private int userNiveau;

  @Override
  public String toString() {
    return "Session{" +
        "userName='" + userName + '\'' +
        ", passWord='" + passWord + '\'' +
        ", userKey=" + userKey +
        ", userNiveau=" + userNiveau +
        '}';
  }

  public Session(int userKey, String userName, String passWord, int userNiveau) {
        this.userName = userName;
        this.passWord = passWord;
        this.userKey = userKey;//id
        this.userNiveau = userNiveau;
    }

    public Session() { userNiveau = 2; }

    public Session(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        userNiveau = 2; //Fordi alle de fremtidige medarbejdere skal bare have læserettigheder
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getUserNiveau() {
        return userNiveau;
    }

    public void setUserNiveau(int userNiveau) {
        this.userNiveau = userNiveau;
    }
}
