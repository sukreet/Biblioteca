package com.twu.biblioteca;

import java.util.Scanner;

public class App {

    private int input;
    private String result;
    private String exitToken = " ";
    private Menu menu;

    public App(Menu menu) {
        this.menu = menu;
    }


    public void displayWelcomeMessage() {

        System.out.println("Welcome");
    }

    public void displayMenu() {
        System.out.println("Main Menu");
        System.out.print(menu.displayMenuOptions());
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        displayWelcomeMessage();
        do {
            displayMenu();

            input = in.nextInt();
            result = menu.computeMenuOption(input);

            System.out.println(result);
        } while (!result.equals(exitToken));
    }

}
