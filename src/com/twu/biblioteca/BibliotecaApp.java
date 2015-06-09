package com.twu.biblioteca;


import java.util.Scanner;


public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaFunctionalities bibliotecaFunctionalities = new BibliotecaFunctionalities();
        Menu menu = new Menu();
        int input;
        String result;
        Scanner in = new Scanner(System.in);

        bibliotecaFunctionalities.displayWelcomeMsg();

        do {
            bibliotecaFunctionalities.displayMenu(menu);

            input = in.nextInt();
            result = menu.computeMenuOption(input);

            System.out.println(result);
        } while (result != null);

    }
}
