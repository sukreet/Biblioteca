package com.twu.biblioteca;

import java.io.IOException;

public class App {

    private int input;
    private String result;
    private String exitToken = " ";
    private Dispatcher dispatcher;
    private Menu menu;
    private ConsoleIO consoleIO;

    public App(Dispatcher dispatcher, Menu menu, ConsoleIO consoleIO) {
        this.dispatcher = dispatcher;
        this.menu = menu;
        this.consoleIO = consoleIO;
    }


    public void displayWelcomeMessage() {

        consoleIO.display("Welcome\n");
    }

    public void displayMenu() {
        consoleIO.display("Main Menu\n");
        consoleIO.display(menu.displayMenuOptions());
    }

    public void start() {

        displayWelcomeMessage();
        do {
            displayMenu();
            try {
                input = consoleIO.readInt();
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = dispatcher.computeMenuOption(input);

            consoleIO.display(result);
        } while (!result.equals(exitToken));
    }

}
