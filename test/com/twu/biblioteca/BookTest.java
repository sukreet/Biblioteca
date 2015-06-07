package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {
    @Test
    public void shouldReturnDetailsOfABookInExpectedFormat() {
        Book book = new Book("Angles and Demons", "Dan Brown", 1999);

        String actualDetails = book.toString();
        String expectedDetails = String.format("%-40s", "Angles and Demons") + String.format("%-40s", "Dan Brown") + String.format("%-40s", 1999);

        assertThat(actualDetails, is(equalTo(expectedDetails)));
    }
}