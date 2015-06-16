package com.twu.biblioteca;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReturnBookTest {

    @Test
    public void shouldGiveProperMsgWhenEnteredBookDoseNotBelongToTheLibrary() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("Learning C");
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        IOcon iOcon = new IOcon(bufferedReader);
        ReturnBook returnBook = new ReturnBook(iOcon, new Books(list));
        String expected = returnBook.action();

        assertThat(expected, is("That is not a valid book to return\n"));
    }

    @Test
    public void shouldGiveProperMsgWhenEnteredBookIsSuccessfullyReturned() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("Learning C");
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        Books books = new Books(list);
        IOcon iOcon = new IOcon(bufferedReader);
        CheckOut checkOut = new CheckOut(iOcon, books);
        ReturnBook returnBook = new ReturnBook(iOcon, books);

        checkOut.action();
        String expected = returnBook.action();


        assertThat(expected, is("Thank you for returning the book.\n"));
    }


}
