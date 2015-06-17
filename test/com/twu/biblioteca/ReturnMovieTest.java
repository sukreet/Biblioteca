package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReturnMovieTest {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MovieList movieList;

    @Before
    public void setup() {
        movies.add(new Movie("Movie1", "Director1", 1999, "7/10"));
        movies.add(new Movie("Movie2", "Director2", 1998, "unrated"));
    }

    @Test
    public void shouldGiveProperMsgWhenEnteredMovieIsNotAValidMovieToReturn() throws IOException {

        ConsoleIO consoleIO = mock(ConsoleIO.class);
        when(consoleIO.read()).thenReturn("Good");
        movieList = new MovieList(movies);
        ReturnMovie returnMovie = new ReturnMovie(consoleIO, movieList);

        String expected = returnMovie.action();

        assertThat(expected, is("That is not a valid movie to return\n"));
    }
    
}
