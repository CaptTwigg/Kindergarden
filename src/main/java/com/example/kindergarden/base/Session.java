package com.example.kindergarden.base;

import org.springframework.util.DigestUtils;

public class Session {
    private String userName;
    private String passWord;
    private boolean isLoggedIn = false;

    public Session(String userName, String passWord) {
        this.userName = userName;
        this.passWord = md5Hasher(passWord);
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
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

    private String md5Hasher(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
    }
}
