package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    HashMap<Integer, MenuOperations> map = new HashMap<Integer, MenuOperations>();
    ArrayList<String> menuList = new ArrayList<String>();

    public Menu() {
        map.put(1, new Books());
        menuList.add("1 : List Of Books");
    }


    public String displayMenuOptions() {
        String displayMenu = "";
        for (int i = 0; i < menuList.size(); i++)
            displayMenu = displayMenu + menuList.get(0);

        return displayMenu;
    }


    public String computeMenuOption(int optionNumber) {
        if (optionNumber > menuList.size() || optionNumber<=0)
            return "Invalid Menu Option";
        Object object;
        object = map.get(optionNumber);
        return object.toString();
    }
}
