package com.example.kindergarden.base;

public class Session {
    private String userName;
    private String passWord;
    private int userKey;
    private int userNiveau;

    //dette er en prøve
    private String newPassWord;
    private String repeatPassWord;

  public String getNewPassWord() {
    return newPassWord;
  }

  public void setNewPassWord(String newPassWord) {
    this.newPassWord = newPassWord;
  }

  public String getRepeatPassWord() {
    return repeatPassWord;
  }

  public void setRepeatPassWord(String repeatPassWord) {
    this.repeatPassWord = repeatPassWord;
  }

  @Override
  public String toString() {
    return "Session{" +
        "userName='" + userName + '\'' +
        ", passWord='" + passWord + '\'' +
        ", userKey=" + userKey +
        ", userNiveau=" + userNiveau +
        ", newPassWord='" + newPassWord + '\'' +
        ", repeatPassWord='" + repeatPassWord + '\'' +
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
