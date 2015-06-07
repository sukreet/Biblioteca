package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {
    @Test
    public void shouldReturnDetailsOfABookInExpecteFormat() {
        Book book = new Book("Angles and Demons", "Dan Brown", 1999);

        String actualDetails = book.toString();
        String expectedDetails = "Angles and Demons" + "\t" + "Dan Brown" + "\t" + "1999";

        assertThat(actualDetails, is(equalTo(expectedDetails)));
    }
}