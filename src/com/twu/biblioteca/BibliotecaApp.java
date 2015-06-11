package com.twu.biblioteca;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class BibliotecaApp {

    public static void main(String[] args) throws IOException {

        ArrayList<Book> books;
        FileHandler readBooks = new FileHandler("listOfBooks.txt");
//        books.add(new Book("Head First Java", "Kathy", 1995));
//        books.add(new Book("Learning C", "John", 2000));
        books = readBooks.readListOfBooks();

        BibliotecaFunctionalities bibliotecaFunctionalities = new BibliotecaFunctionalities();
        Menu menu = new Menu(books);

        bibliotecaFunctionalities.displayWelcomeMsg();
        bibliotecaFunctionalities.start(menu);

    }
}
