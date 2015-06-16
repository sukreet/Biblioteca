package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieTest {

    @Test
    public void shouldReturnDetailsOfAMovieInExpectedFormat() {
        Movie movie = new Movie("Movie Name", "Director Mane", 1999, "7/10");

        String actualDetails = movie.toString();
        String expectedDetails = String.format("%-40s", "Movie Name") +
                String.format("%-40s", "Director Mane") +
                String.format("%-40s", 1999) +
                String.format("%-40s", "7/10");

        assertThat(actualDetails, is(equalTo(expectedDetails)));

    }
}