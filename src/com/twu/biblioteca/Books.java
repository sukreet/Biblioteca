package com.twu.biblioteca;

import java.util.ArrayList;

public class Books implements MenuOperations {
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
}
