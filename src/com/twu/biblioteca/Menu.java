package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    HashMap<Integer, MenuOperations> map = new HashMap<Integer, MenuOperations>();
    ArrayList<String> menuOptions = new ArrayList<String>();

    public Menu() {
        map.put(1, new Books());
    }


    public String computeMenuOption(int optionNumber) {
        Object object;
        object = map.get(optionNumber);
        return object.toString();
    }
}
