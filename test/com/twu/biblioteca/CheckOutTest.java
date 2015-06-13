package com.twu.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//import static org.hamcrest.CoreMatchers.is;

public class CheckOutTest {

    @Test
    public void shouldGiveProperMsgWhenEnteredBookIsNotAvailable() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("Good");
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));

        CheckOut checkout = new CheckOut(bufferedReader, new Books(list));
        String expected = checkout.toString();
        assertThat(expected, is("That book is not available.\n"));
    }

    @Test
    public void shouldGiveProperMsgWhenEnteredBookIsAvailableaAndCheckedOut() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("Head First Java");
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));

        CheckOut checkout = new CheckOut(bufferedReader, new Books(list));
        String expected = checkout.toString();
        assertThat(expected, is("Thank you! Enjoy the book.\n"));
    }


}
