package com.twu.biblioteca;

public class Book {
    String author;
    String name;
    int yearOfPublication;
    Boolean isAvailable;

    public Book(String name, String author, int yearOfPublication) {
        this.author = author;
        this.name = name;
        this.yearOfPublication = yearOfPublication;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return (String.format("%-40s", name) + String.format("%-40s", author) + String.format("%-40s", yearOfPublication));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (yearOfPublication != book.yearOfPublication) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return !(name != null ? !name.equals(book.name) : book.name != null);

    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + yearOfPublication;
        return result;
    }
}
