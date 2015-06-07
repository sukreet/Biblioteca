package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BooksTest {

    @Test
    public void checkIfBookListInDetailsIsBeingDisplayedInProperFormat() {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Head First Java", "Kathy", 1995));
        listOfBooks.add(new Book("Learning C", "John", 2000));
        Books books = new Books(listOfBooks);

        String expectedFormat = books.toString();
        String actualFormat = String.format("%-40s", "Head First Java") + String.format("%-40s", "Kathy") + String.format("%-40s", 1995) + System.lineSeparator()
                + String.format("%-40s", "Learning C") + String.format("%-40s", "John") + String.format("%-40s", 2000) + System.lineSeparator();

        assertEquals(expectedFormat, actualFormat);
    }

}