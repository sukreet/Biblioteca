package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    HashMap<Integer, MenuOperations> map = new HashMap<Integer, MenuOperations>();
    ArrayList<String> menuList = new ArrayList<>();

    public Menu(Books books, Quit quit, CheckOut checkout, ReturnBook returnBook) {
        map.put(1, books);
        map.put(2, quit);
        map.put(3, checkout);
        map.put(4, returnBook);
        menuList.add("1 : List Of Books");
        menuList.add("2 : Quit");
        menuList.add("3 : Checkout Book");
        menuList.add("4 : Return Book");
    }


    public String displayMenuOptions() {
        String displayMenu = "";
        for (int i = 0; i < menuList.size(); i++) {
            displayMenu = displayMenu + menuList.get(i) + System.lineSeparator();
        }
        return displayMenu;
    }


    public String computeMenuOption(int optionNumber) {
        if (optionNumber > menuList.size() || optionNumber <= 0)
            return "Select a valid option!";
        Object object;
        object = map.get(optionNumber);
        return object.toString();
    }
}
