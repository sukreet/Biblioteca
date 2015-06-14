package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.IOException;

public class ReturnBook implements  MenuOperations {
    private String successFullBookReturntMsg;
    private String unSuccessFullBookReturnMsg;
    private Books books;
    private String name;
    private BufferedReader bufferedReader;

    public ReturnBook(BufferedReader bufferedReader, Books books) {
        this.bufferedReader = bufferedReader;
        successFullBookReturntMsg = "Thank you for returning the book.\n";
        unSuccessFullBookReturnMsg = "That is not a valid book to return\n";
        this.books = books;
    }

    @Override
    public String toString() {
        try {
            name = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (books.returnBook(name))
            return successFullBookReturntMsg;
        return unSuccessFullBookReturnMsg;
    }


}
