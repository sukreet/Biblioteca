package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReadMovieListTest {


    @Test
    public void shouldReadListOfAvailableBooks() throws IOException {
        String testFileName = "listOfMovies.txt";
        ReadMovieList readMovies = new ReadMovieList(testFileName);
        ArrayList<Movie> actualListOfMovies = readMovies.readListOfMovies();
        MovieList actualMovieList = new MovieList(actualListOfMovies);
        ArrayList<Movie> expectedListOfMovies = new ArrayList<>();
        expectedListOfMovies.add(new Movie("Movie1", "Director1", 2009, "7/10"));
        expectedListOfMovies.add(new Movie("Movie2", "Director2", 2012, "unrated"));
        expectedListOfMovies.add(new Movie("Movie3", "Director3", 1999, "5/10"));
        MovieList expectedMovieList = new MovieList(expectedListOfMovies);

        assertThat(actualMovieList, is(expectedMovieList));
    }
}
