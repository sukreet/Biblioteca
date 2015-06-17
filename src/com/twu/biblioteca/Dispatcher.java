package com.twu.biblioteca;


import java.util.HashMap;

public class Dispatcher {
    private HashMap<Integer, MenuOperations> map = new HashMap<Integer, MenuOperations>();
    Menu menu;

    public Dispatcher(BookList bookList, Quit quit, CheckOutBook checkout, ReturnBook returnBook, MovieList movieList, Menu menu) {
        this.menu = menu;
        map.put(1, bookList);
        map.put(2, quit);
        map.put(3, checkout);
        map.put(4, returnBook);
        map.put(5, movieList);
    }

    public String computeMenuOption(int optionNumber) {
        if (optionNumber > menu.returnMenuSize() || optionNumber <= 0)
            return "Select a valid option!";
        MenuOperations menuOperations;
        menuOperations = map.get(optionNumber);
        return menuOperations.action();
    }
}
