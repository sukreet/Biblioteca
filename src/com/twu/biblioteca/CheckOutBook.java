package com.twu.biblioteca;


import java.io.IOException;

public class CheckOutBook implements MenuOperations {
    private String successFullCheckOutMsg;
    private String unSuccessFullCheckOutMsg;
    private BookList bookList;
    private String name;
    private ConsoleIO consoleIO;

    public CheckOutBook(ConsoleIO consoleIO, BookList bookList) {
        this.consoleIO = consoleIO;
        successFullCheckOutMsg = "Thank you! Enjoy the book.\n";
        unSuccessFullCheckOutMsg = "That book is not available.\n";
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
            return successFullCheckOutMsg;
        return unSuccessFullCheckOutMsg;
    }
}
