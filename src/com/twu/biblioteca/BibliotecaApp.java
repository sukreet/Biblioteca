package com.twu.biblioteca;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class BibliotecaApp {

    public static void main(String[] args) throws IOException {

        ArrayList<Book> books;
        FileHandler fileHandler = new FileHandler("listOfBooks.txt");
        books = fileHandler.readListOfBooks();

        BibliotecaFunctionalities bibliotecaFunctionalities = new BibliotecaFunctionalities();
        Menu menu = new Menu(books);

        bibliotecaFunctionalities.displayWelcomeMsg();
        bibliotecaFunctionalities.start(menu);

    }
}
