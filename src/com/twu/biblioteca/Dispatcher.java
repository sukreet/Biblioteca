package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.HashMap;

public class Dispatcher {
    private HashMap<Integer, MenuOperations> map = new HashMap<Integer, MenuOperations>();
    Menu menu;
    public Dispatcher(Books books, Quit quit, CheckOut checkout, ReturnBook returnBook, Menu menu) {
        this.menu = menu;
        map.put(1, books);
        map.put(2, quit);
        map.put(3, checkout);
        map.put(4, returnBook);
    }

    public String computeMenuOption(int optionNumber) {
        if (optionNumber > menu.returnMenuSize() || optionNumber <= 0)
            return "Select a valid option!";
        MenuOperations menuOperations;
        menuOperations = map.get(optionNumber);
        return menuOperations.action();
    }
}
