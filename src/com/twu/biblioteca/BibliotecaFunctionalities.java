package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaFunctionalities {

    private int input;
    private String result;
    private String exitToken = " ";


    public void displayWelcomeMsg() {

        System.out.println("Welcome");
    }

    public void displayMenu(Menu menu) {
        System.out.println("Main Menu");
        System.out.print(menu.displayMenuOptions());
    }

    public void start(Menu menu) {
        Scanner in = new Scanner(System.in);
        do {
            displayMenu(menu);

            input = in.nextInt();
            result = menu.computeMenuOption(input);

            System.out.println(result);
        } while (!result.equals(exitToken));
    }

}
