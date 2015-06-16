package com.twu.biblioteca;


import java.io.IOException;

public class CheckOut implements MenuOperations {
    private String sucessFullCheckOutMsg;
    private String unSucessFullCheckOutMsg;
    private BookList bookList;
    private String name;
    ConsoleIO consoleIO;

    public CheckOut(ConsoleIO consoleIO, BookList bookList) {
        this.consoleIO = consoleIO;
        sucessFullCheckOutMsg = "Thank you! Enjoy the book.\n";
        unSucessFullCheckOutMsg = "That book is not available.\n";
        this.bookList = bookList;
    }

    @Override
    public String action() {
        try {
            name = consoleIO.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bookList.issueBook(name))
            return sucessFullCheckOutMsg;
        return unSucessFullCheckOutMsg;
    }

}
