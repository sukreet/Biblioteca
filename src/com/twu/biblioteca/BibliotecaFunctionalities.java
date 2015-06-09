package com.twu.biblioteca;

public class BibliotecaFunctionalities {

    public void displayWelcomeMsg() {

        System.out.println("Welcome");
    }

    public void displayMenu(Menu menu) {
        System.out.println("Main Menu");
        System.out.print(menu.displayMenuOptions());
    }
}
