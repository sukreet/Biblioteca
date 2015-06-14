package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.IOException;

public class CheckOut implements MenuOperations {
    private String sucessFullCheckOutMsg;
    private String unSucessFullCheckOutMsg;
    private Books books;
    private String name;
    private BufferedReader bufferedReader;

    public CheckOut(BufferedReader bufferedReader, Books books) {
        this.bufferedReader = bufferedReader;
        sucessFullCheckOutMsg = "Thank you! Enjoy the book.\n";
        unSucessFullCheckOutMsg = "That book is not available.\n";
        this.books = books;
    }

    @Override
    public String action() {
        try {
            name = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (books.issueBook(name))
            return sucessFullCheckOutMsg;
        return unSucessFullCheckOutMsg;
    }

}
