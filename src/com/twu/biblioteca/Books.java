package com.twu.biblioteca;

import java.util.ArrayList;

public class Books implements MenuOperations {
    private ArrayList<Book> books = new ArrayList<>();

    public Books(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String list = "";
        for (Book book : books)
            list += book.toString() + System.lineSeparator();
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books1 = (Books) o;

        return !(books != null ? !books.equals(books1.books) : books1.books != null);

    }

    @Override
    public int hashCode() {
        return books != null ? books.hashCode() : 0;
    }


    public boolean checkExistence(String name) {
        for (Book book : books) {
            if (book.checkNameIs(name))
                return true;
        }
        return false;
    }


}
