package com.twu.biblioteca;


import java.util.Scanner;


public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaFunctionalities bibliotecaFunctionalities = new BibliotecaFunctionalities();
        Menu menu = new Menu();

        bibliotecaFunctionalities.displayWelcomeMsg();
        bibliotecaFunctionalities.start(menu);

    }
}
