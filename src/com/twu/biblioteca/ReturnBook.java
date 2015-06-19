package com.twu.biblioteca;


import java.io.IOException;

public class ReturnBook implements MenuOperations {
    private String successFullBookReturntMsg;
    private String unSuccessFullBookReturnMsg;
    private BookList bookList;
    private String name;
    private ConsoleIO consoleIO;
    private User authorisedUser;
    private History history;


    public ReturnBook(ConsoleIO consoleIO, BookList bookList, User authorisedUser, History history) {
        this.consoleIO = consoleIO;
        successFullBookReturntMsg = "Thank you for returning the book.\n";
        unSuccessFullBookReturnMsg = "That is not a valid book to return\n";
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
        if (bookList.returnBook(name)) {
            history.removeRecord(name, "Book");
            return successFullBookReturntMsg;
        }
        return unSuccessFullBookReturnMsg;
    }

}
