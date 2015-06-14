package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class EntryPoint {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        ArrayList<Book> seedDataForBooks;
        FileHandler fileHandler = new FileHandler("listOfBooks.txt");
        seedDataForBooks = fileHandler.readListOfBooks();
        Books books = new Books(seedDataForBooks);
        Quit quit =  new Quit();
        CheckOut checkOut = new CheckOut(bufferedReader,books);

        Menu menu = new Menu(books, quit , checkOut);
        new App(menu).start(bufferedReader);
    }
}
