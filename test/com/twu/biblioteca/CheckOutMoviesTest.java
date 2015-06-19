package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckOutMoviesTest {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MovieList movieList;

    @Before
    public void setup() {
        movies.add(new Movie("Movie1", "Director1", 1999, "7/10"));
        movies.add(new Movie("Movie2", "Director2", 1998, "unrated"));
    }

    @Test
    public void shouldGiveProperMsgWhenEnteredMovieIsNotAvailable() throws IOException {

        ConsoleIO consoleIO = mock(ConsoleIO.class);
        when(consoleIO.read()).thenReturn("Good");
        movieList = new MovieList(movies);
        User authorisedUser = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        History history = new History();
        CheckOutMovies checkOutMovies = new CheckOutMovies(consoleIO, movieList, authorisedUser, history);

        String expected = checkOutMovies.action();

        assertThat(expected, is("That movie is not available.\n"));
    }

    @Test
    public void shouldGiveProperMsgWhenEnteredMovieIsAvailable() throws IOException {

        ConsoleIO consoleIO = mock(ConsoleIO.class);
        when(consoleIO.read()).thenReturn("Movie1");
        movieList = new MovieList(movies);
        User authorisedUser = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        History history = new History();
        CheckOutMovies checkOutMovies = new CheckOutMovies(consoleIO, movieList, authorisedUser, history);

        String expected = checkOutMovies.action();

        assertThat(expected, is("Thank you! Enjoy the movie.\n"));
    }


}
