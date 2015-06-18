package com.twu.biblioteca;

import java.util.ArrayList;

public class Login {
    private ArrayList<User> userList = new ArrayList<>();

    public Login(ArrayList<User> userList) {
        this.userList = userList;
    }

    public User authoriseUser(String libraryID, String password) {
        for (User user : userList) {
            if (user.validate(libraryID, password))
                return user;
        }
        return null;
    }
}
