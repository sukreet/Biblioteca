package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldReturnDetailsOfABookInExpectedFormat() {
        Book book = new Book("Angles and Demons", "Dan Brown", 1999);

        String actualDetails = book.toString();
        String expectedDetails = String.format("%-40s", "Angles and Demons") + String.format("%-40s", "Dan Brown") + String.format("%-40s", 1999);

        assertThat(actualDetails, is(equalTo(expectedDetails)));
    }

    @Test
    public void testForComparingNullObjectsWithA() {
        Book firstBook = new Book("book1", "author", 1992);

        assertThat(firstBook, not(equalTo(null)));
    }

    @Test
    public void testForDifferentObjects() {
        Book firstBook = new Book("book1", "author", 1992);
        Object one = new Integer(1);

        assertThat(firstBook, not(equalTo(one)));
    }

    @Test
    public void testForEquality() {
        Book firstBook = new Book("book1", "author", 1992);
        ;
        Book secondBook = new Book("book1", "author", 1992);
        ;

        assertEquals(firstBook, secondBook);
    }

    @Test
    public void testForReflexivity() {
        Book firstBook = new Book("book1", "author", 1992);

        assertEquals(firstBook, firstBook);
    }

    @Test
    public void testForSymmetry() {
        Book firstBook = new Book("book1", "author", 1992);
        Book secondBook = new Book("book1", "author", 1992);

        assertEquals(firstBook, secondBook);
        assertEquals(secondBook, firstBook);
    }

    @Test
    public void testForTransitivity() {
        Book firstBook = new Book("book1", "author", 1992);
        Book secondBook = new Book("book1", "author", 1992);
        Book thirdBook = new Book("book1", "author", 1992);

        assertEquals(firstBook, secondBook);
        assertEquals(secondBook, firstBook);
        assertEquals(firstBook, thirdBook);
    }

    @Test
    public void equalityTestForHashCode() {
        Book firstBook = new Book("book1", "author", 1992);
        Book secondBook = new Book("book1", "author", 1992);

        assertEquals(firstBook.hashCode(), secondBook.hashCode());
    }

    @Test
    public void shouldBeAbleToCheckIfbookIsAvailableOrnot(){
        Book book = new Book("book1", "author", 1992);

        assertTrue(book.checkBookAvailability());
    }

    @Test
    public void shouldBeAbleToMakeBookUnAailable() {
        Book book = new Book("book1", "author", 1992);
        book.issueBook();
        assertFalse(book.checkBookAvailability());
    }
}