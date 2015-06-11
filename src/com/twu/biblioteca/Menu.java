package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    HashMap<Integer, MenuOperations> map = new HashMap<Integer, MenuOperations>();
    ArrayList<String> menuList = new ArrayList<String>();

    public Menu(ArrayList<Book> books) {
        map.put(1, new Books(books));
        map.put(2, new Quit());
        menuList.add("1 : List Of Books");
        menuList.add("2 : Quit");
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
