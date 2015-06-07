package com.twu.biblioteca;

public class Book {
    String author;
    String name;
    int yearOfPublication;

    public Book(String name, String author, int yearOfPublication) {
        this.author = author;
        this.name = name;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return (String.format("%-40s", name) + String.format("%-40s", author) + String.format("%-40s", yearOfPublication));
    }
}
