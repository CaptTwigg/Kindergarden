package com.example.kindergarden;

public class Login {
    private String userName;
    private String passWord;

    public Login(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Login() {

    }

    @Override
    public String toString() {
        return "Login{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public boolean validateUser(String userName, String passWord){
        return this.userName.equalsIgnoreCase(userName) && this.passWord.equals(passWord);
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
}
