package com.example.kindergarden.services;

import com.example.kindergarden.base.Login;
import org.springframework.util.DigestUtils;
import sun.rmi.runtime.Log;

import java.security.MessageDigest;
import java.util.ArrayList;

public class ServiceLogin {
    static ArrayList<Login> logins = new ArrayList<>();

    public void getUsers() {

    }

    public static boolean isSomeoneLoggedIn() {
        for(Login login: logins) {
            if(login.isIsLoggedIn()) {
                return true;
            }
        }

        return false;
    }

    public static void setLogin(String username, String password) {
        for(Login login: logins) {
            if(login.getUserName().equals(username) && login.getPassWord().equals(md5Hasher(password))) {
                login.setIsLoggedIn(true);
                break;
            }
        }
    }

    private static String md5Hasher(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
    }

    public static ArrayList<Login> getLogins() {
        return logins;
    }
}
