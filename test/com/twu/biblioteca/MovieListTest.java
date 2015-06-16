package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MovieListTest {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MovieList movieList;

    @Before
    public void setup() {
        movies.add(new Movie("Movie1", "Director1", 1999, "7/10"));
        movies.add(new Movie("Movie2", "Director2", 1998, "unrated"));
    }


    @Test
    public void shouldDisplayBookListInDetailsInProperFormat() {
        movieList = new MovieList(movies);
        String expectedFormat = movieList.action();
        String actualFormat = String.format("%-40s", "Movie1") + String.format("%-40s", "Director1") +
                String.format("%-40s", 1999) + String.format("%-40s", "7/10") + System.lineSeparator() +
                String.format("%-40s", "Movie2") + String.format("%-40s", "Director2") +
                String.format("%-40s", 1998) + String.format("%-40s", "unrated") + System.lineSeparator();

        assertEquals(expectedFormat, actualFormat);

    }
}