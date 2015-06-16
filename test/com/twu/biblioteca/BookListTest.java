package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void shouldDisplayBookListInDetailsInProperFormat() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Learning C", "John", 2000));
        BookList booklist = new BookList(books);

        String expectedFormat = booklist.action();
        String actualFormat = String.format("%-40s", "Head First Java") + String.format("%-40s", "Kathy") + String.format("%-40s", 1995) + System.lineSeparator()
                + String.format("%-40s", "Learning C") + String.format("%-40s", "John") + String.format("%-40s", 2000) + System.lineSeparator();

        assertEquals(expectedFormat, actualFormat);
    }

    @Test
    public void testForReflexivity() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList bookList = new BookList(list);

        assertEquals(bookList, bookList);
    }

    @Test
    public void testForComparingNullObjectsWithA() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList book = new BookList(list);

        assertThat(book, not(equalTo(null)));
    }

    @Test
    public void testForEquality() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList firstBookList = new BookList(list);
        BookList secondBookList = new BookList(list);

        assertEquals(firstBookList, secondBookList);
    }

    @Test
    public void testForDifferentObjects() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList bookList = new BookList(list);
        Object one = new Integer(1);

        assertThat(bookList, not(equalTo(one)));
    }

    @Test
    public void testForTransitivity() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList firstBookList = new BookList(list);
        BookList secondBookList = new BookList(list);
        BookList thirdBookList = new BookList(list);

        assertEquals(firstBookList, secondBookList);
        assertEquals(secondBookList, firstBookList);
        assertEquals(firstBookList, thirdBookList);
    }

    @Test
    public void testForSymmetry() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList firstBookList = new BookList(list);
        BookList secondBookList = new BookList(list);

        assertEquals(firstBookList, secondBookList);
        assertEquals(secondBookList, firstBookList);
    }

    @Test
    public void equalityTestForHashCode() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList firstBookList = new BookList(list);
        BookList secondBookList = new BookList(list);

        assertEquals(firstBookList.hashCode(), secondBookList.hashCode());
    }


    @Test
    public void shouldCheckIfABookDoesNotExistInAListOfBooks() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList bookList = new BookList(list);

        assertFalse(bookList.checkExistence("book1"));
    }

    @Test
    public void shouldCheckIfABookExistInAListOfBooks() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList bookList = new BookList(list);

        assertTrue(bookList.checkExistence("Head First Java"));
    }

    @Test
    public void shouldCheckIfAnExistingBookIsAvailableInAListOfBooks() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList bookList = new BookList(list);

        assertTrue(bookList.checkAvailability("Head First Java"));
    }


    @Test
    public void shouldMakeAnExistingBookUnAvailableInAListOfBooks() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList bookList = new BookList(list);
        bookList.issueBook("Head First Java");

        assertFalse(bookList.checkAvailability("Head First Java"));
    }

    @Test
    public void shouldDisplayDetailsOfAvailableBooksInProperFormat() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Learning C", "John", 2000));
        BookList booklist = new BookList(books);

        booklist.issueBook("Learning C");
        String actualList = booklist.action();
        String expectedList = String.format("%-40s", "Head First Java") + String.format("%-40s", "Kathy") + String.format("%-40s", 1995) + System.lineSeparator();

        assertEquals(expectedList, actualList);
    }

    @Test
    public void shouldMakeAnExistingBookAvailableInAListOfBooksWhenItIsReturned() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList bookList = new BookList(list);
        bookList.issueBook("Head First Java");
        bookList.returnBook("Head First Java");

        assertTrue(bookList.checkAvailability("Head First Java"));
    }
}