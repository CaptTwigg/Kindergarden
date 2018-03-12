package com.example.kindergarden.base;

import org.springframework.util.DigestUtils;

public class Session {
    private String userName;
    private String passWord;
    private int userKey;
    private int userNiveau;

    public Session(String userName, String passWord, int userKey, int userNiveau) {
        this.userName = userName;
        this.passWord = passWord;
        this.userKey = userKey;
        this.userNiveau = userNiveau;
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
