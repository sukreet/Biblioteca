package com.twu.biblioteca;

import java.util.ArrayList;

public class Books implements MenuOperations{
    private ArrayList<Book> books = new ArrayList<>();

    public Books() {

        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Learning C", "John", 2000));
    }

    @Override
    public String toString() {
        String list = "";
        for (Book book : books)
            list += book.toString() + System.lineSeparator();
        return list;
    }
}
