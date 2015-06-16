package com.twu.biblioteca;


import java.io.IOException;

public class ReturnBook implements MenuOperations {
    private String successFullBookReturntMsg;
    private String unSuccessFullBookReturnMsg;
    private BookList bookList;
    private String name;
    private ConsoleIO consoleIO;

    public ReturnBook(ConsoleIO consoleIO, BookList bookList) {
        this.consoleIO = consoleIO;
        successFullBookReturntMsg = "Thank you for returning the book.\n";
        unSuccessFullBookReturnMsg = "That is not a valid book to return\n";
        this.bookList = bookList;
    }

    @Override
    public String action() {
        try {
            name = consoleIO.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bookList.returnBook(name))
            return successFullBookReturntMsg;
        return unSuccessFullBookReturnMsg;
    }

}
