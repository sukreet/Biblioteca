package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;


public class BibliotecaApp {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Learning C", "John", 2000));


        BibliotecaFunctionalities bibliotecaFunctionalities = new BibliotecaFunctionalities();
        Menu menu = new Menu(books);

        bibliotecaFunctionalities.displayWelcomeMsg();
        bibliotecaFunctionalities.start(menu);

    }
}
