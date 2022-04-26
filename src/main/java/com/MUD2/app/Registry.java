package com.MUD2.app;

import java.util.*;

import com.MUD2.app.tile.Map;

public class Registry {
    private Hashtable<String, User> users;
    private User activeUser;
    public Registry () {
        this.users = new Hashtable<String,User>();
        this.activeUser = null;
    }
    public void addUser(String Username, String password) {
        this.users.put(Username, new User(Username, password));
    }
    public void changePassword(String Username, String password, String newPassword) {
        User user= users.get(Username);

        if (user.validatePassword(password) == true) {
            user.setPassword(newPassword);
            users.put(Username, user);
            System.out.println("Password Updated");
        } else {
            System.out.println("Wrong Password");
        }
    }

    public void viewHistory() {
        if (activeUser != null) {
            System.out.println(activeUser.getHistory().toString());
        } else {
            System.out.println("Must login to view history");
        }
    }

    public void joinGame (Map map ) {
            activeUser.setCurrentGame(map);
    }

    public void login (String Username, String Password) {
        if (users.get(Username) != null) {
           User user =  users.get(Username);
           if (user.validatePassword(Password) == true) {
               activeUser = user;
           }
        } else {
            System.out.println("Invalid Login");
        }
    }
}
