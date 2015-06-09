package com.twu.biblioteca;


public class BibliotecaFunctionalities {

    public void displayWelcomeMsg() {

        System.out.println("Welcome");
    }

    public void displayMenu() {

        System.out.println("Main Menu");
        Menu menu = new Menu();
        menu.displayMenuOptions();

    }

    public void invalidChoice() {
        System.out.println("Select a valid option!");
    }
}
