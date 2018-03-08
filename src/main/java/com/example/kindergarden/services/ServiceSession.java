package com.example.kindergarden.services;

import com.example.kindergarden.base.Session;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;

public class ServiceSession {
    static ArrayList<Session> sessions = new ArrayList<>();

    public void getUsers() {

    }

    public static boolean isSomeoneLoggedIn() {
        for(Session session : sessions) {
            if(session.isIsLoggedIn()) {
                return true;
            }
        }

        return false;
    }

    public static void setLogin(String username, String password) {
        for(Session session : sessions) {
            if(session.getUserName().equals(username) && session.getPassWord().equals(md5Hasher(password))) {
                session.setIsLoggedIn(true);
                break;
            }
        }
    }

    private static String md5Hasher(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
    }

    public static ArrayList<Session> getSessions() {
        return sessions;
    }

    public static void logOut() {
        for(Session session : sessions) {
            session.setIsLoggedIn(false);
        }
    }
}
