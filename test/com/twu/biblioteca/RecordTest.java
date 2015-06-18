package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RecordTest {
    @Test
    public void shouldReturnDetailsOfABookInExpectedFormat() {
        Record record = new Record("Sukreet", "Macbeth", "Book");

        String actualDetails = record.toString();
        String expectedDetails = String.format("%-40s", "Sukreet") + String.format("%-40s", "Macbeth") + String.format("%-40s", "Book");

        assertThat(actualDetails, is(equalTo(expectedDetails)));
    }
}
