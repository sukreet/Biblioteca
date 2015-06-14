package com.twu.biblioteca;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReturnTest {
    @Test
    public void shouldGiveProperMsgWhenEnteredBookDoseNotBelongToTheLibrary() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("Learning C");
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));

        ReturnBook returnBook = new ReturnBook(bufferedReader, new Books(list));
        String expected = returnBook.toString();

        assertThat(expected, is("That is not a valid book to return\n"));
    }

  }
