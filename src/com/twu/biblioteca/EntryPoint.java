package com.twu.biblioteca;


import java.io.IOException;
import java.util.ArrayList;


public class EntryPoint {

    public static void main(String[] args) throws IOException {

        ArrayList<Book> seedDataForBooks;
        FileHandler fileHandler = new FileHandler("listOfBooks.txt");
        seedDataForBooks = fileHandler.readListOfBooks();

        Menu menu = new Menu(new Books(seedDataForBooks));
        new App(menu).start();
    }
}
