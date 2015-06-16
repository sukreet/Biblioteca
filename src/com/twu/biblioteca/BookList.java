package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList implements MenuOperations {
    private ArrayList<Book> books = new ArrayList<>();

    public BookList(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String action() {
        String list = "";
        for (Book book : books)
            if (book.Availability())
                list += book.toString() + System.lineSeparator();
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookList bookList1 = (BookList) o;

        return !(books != null ? !books.equals(bookList1.books) : bookList1.books != null);

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


    public boolean checkAvailability(String name) {
        for (Book book : books) {
            if (book.checkNameIs(name))
                return book.Availability();
        }
        return false;
    }

    public boolean issueBook(String name) {
        for (Book book : books) {
            if (book.checkNameIs(name) && book.Availability()) {
                book.issueBook();
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String name) {
        for (Book book : books) {
            if (book.checkNameIs(name) && !book.Availability()) {
                book.returnBook();
                return true;
            }
        }
        return false;
    }
}
