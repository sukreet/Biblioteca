package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

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

    public void start(BufferedReader bufferedReader) {

        displayWelcomeMessage();
        do {
            displayMenu();
            try {
                String st = bufferedReader.readLine();
                input = Integer.parseInt(st);
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = menu.computeMenuOption(input);

            System.out.println(result);
        } while (!result.equals(exitToken));
    }

}
