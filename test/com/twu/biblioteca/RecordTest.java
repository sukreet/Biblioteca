package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class RecordTest {

    @Test
    public void shouldReturnDetailsOfARecordInExpectedFormat() {
        Record record = new Record("Sukreet", "Macbeth", "Book");

        String actualDetails = record.toString();
        String expectedDetails = String.format("%-40s", "Sukreet") + String.format("%-40s", "Macbeth") + String.format("%-40s", "Book");

        assertThat(actualDetails, is(equalTo(expectedDetails)));
    }

    @Test
    public void shouldReturnFalseIfInvalidNameAndTypeIsPassed() {
        Record record = new Record("Sukreet", "Macbeth", "Book");

        assertFalse(record.match("Sukreet", "Movie"));
    }

}
