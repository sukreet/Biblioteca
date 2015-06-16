package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menuList = new ArrayList<String>();

    public Menu() {
        menuList.add("1 : List Of Books");
        menuList.add("2 : Quit");
        menuList.add("3 : Checkout Book");
        menuList.add("4 : Return Book");
        menuList.add("5 : List Of Movies");
    }

    public int returnMenuSize() {
        return menuList.size();
    }

    public String displayMenuOptions() {
        String displayMenu = "";
        for (int i = 0; i < menuList.size(); i++) {
            displayMenu = displayMenu + menuList.get(i) + System.lineSeparator();
        }
        return displayMenu;
    }
}
