package com.twu.biblioteca;


import java.io.IOException;

public class CheckOutBook implements MenuOperations {
    private String successFullCheckOutMsg;
    private String unSuccessFullCheckOutMsg;
    private BookList bookList;
    private String name;
    private ConsoleIO consoleIO;
    private User authorisedUser;
    private History history;


    public CheckOutBook(ConsoleIO consoleIO, BookList bookList, User authorisedUser, History history) {
        this.consoleIO = consoleIO;
        successFullCheckOutMsg = "Thank you! Enjoy the book.\n";
        unSuccessFullCheckOutMsg = "That book is not available.\n";
        this.bookList = bookList;
        this.authorisedUser = authorisedUser;
        this.history = history;
    }

    @Override
    public String action() {
        try {
            name = consoleIO.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bookList.issueBook(name)) {
            history.addRecord(authorisedUser.nameOfUser(),name,"Book");
            return successFullCheckOutMsg;
        }
        return unSuccessFullCheckOutMsg;
    }
}
