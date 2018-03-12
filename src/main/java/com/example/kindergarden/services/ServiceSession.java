package com.example.kindergarden.services;

import com.example.kindergarden.FileHandler;
import com.example.kindergarden.base.Session;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;

public class ServiceSession {
    private static Session session = null;
    private FileHandler fileHandler;

    public ServiceSession(){
        fileHandler = new FileHandler("logins.txt");
    }

    public static boolean isSomeoneLoggedIn() {
        return session != null;
    }

    public boolean checkLogin(String username, String password) {
        if(fileHandler.checkLogin(username, md5Hasher(password))) {
            session = fileHandler.getLogion(username, md5Hasher(password));
            return true;
        } else {
            return false;
        }
    }

    private String md5Hasher(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

    public static Session getCurrentSession() {
        return session;
    }

    public static void logOut() {
        session = null;
    }
}
