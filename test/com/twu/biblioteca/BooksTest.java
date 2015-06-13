package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BooksTest {

    @Test
    public void shouldDisplayBookListInDetailsInProperFormat() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Learning C", "John", 2000));
        Books booklist = new Books(books);

        String expectedFormat = booklist.toString();
        String actualFormat = String.format("%-40s", "Head First Java") + String.format("%-40s", "Kathy") + String.format("%-40s", 1995) + System.lineSeparator()
                + String.format("%-40s", "Learning C") + String.format("%-40s", "John") + String.format("%-40s", 2000) + System.lineSeparator();

        assertEquals(expectedFormat, actualFormat);
    }

    @Test
    public void testForReflexivity() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        Books books = new Books(list);

        assertEquals(books, books);
    }

    @Test
    public void testForComparingNullObjectsWithA() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        Books book = new Books(list);

        assertThat(book, not(equalTo(null)));
    }

    @Test
    public void testForEquality() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        Books firstBooks = new Books(list);
        Books secondBooks = new Books(list);

        assertEquals(firstBooks, secondBooks);
    }

    @Test
    public void testForDifferentObjects() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        Books books = new Books(list);
        Object one = new Integer(1);

        assertThat(books, not(equalTo(one)));
    }

    @Test
    public void testForTransitivity() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        Books firstBooks = new Books(list);
        Books secondBooks = new Books(list);
        Books thirdBooks = new Books(list);

        assertEquals(firstBooks, secondBooks);
        assertEquals(secondBooks, firstBooks);
        assertEquals(firstBooks, thirdBooks);
    }

    @Test
    public void testForSymmetry() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        Books firstBooks = new Books(list);
        Books secondBooks = new Books(list);

        assertEquals(firstBooks, secondBooks);
        assertEquals(secondBooks, firstBooks);
    }

    @Test
    public void equalityTestForHashCode() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        Books firstBooks = new Books(list);
        Books secondBooks = new Books(list);

        assertEquals(firstBooks.hashCode(), secondBooks.hashCode());
    }

}