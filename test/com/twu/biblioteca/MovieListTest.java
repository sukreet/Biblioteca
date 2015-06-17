package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

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

    @Test
    public void testForReflexivity() {
        movieList = new MovieList(movies);

        assertEquals(movieList, movieList);
    }

    @Test
    public void testForComparingNullObjectsWithA() {
        movieList = new MovieList(movies);

        assertThat(movieList, not(equalTo(null)));
    }

    @Test
    public void testForEquality() {
        MovieList movieListOne = new MovieList(movies);
        MovieList movieListTwo = new MovieList(movies);

        assertEquals(movieListOne, movieListTwo);
    }

    @Test
    public void testForDifferentObjects() {
        movieList = new MovieList(movies);
        Object one = new Integer(1);

        assertThat(movieList, not(equalTo(one)));
    }

    @Test
    public void testForTransitivity() {
        MovieList movieListOne = new MovieList(movies);
        MovieList movieListTwo = new MovieList(movies);
        MovieList thirdBookListThree = new MovieList(movies);

        assertEquals(movieListOne, movieListOne);
        assertEquals(thirdBookListThree, movieListTwo);
        assertEquals(movieListOne, thirdBookListThree);
    }

    @Test
    public void testForSymmetry() {

        MovieList movieListOne = new MovieList(movies);
        MovieList movieListTwo = new MovieList(movies);

        assertEquals(movieListOne, movieListTwo);
        assertEquals(movieListTwo, movieListOne);
    }

    @Test
    public void equalityTestForHashCode() {

        MovieList movieListOne = new MovieList(movies);
        MovieList movieListTwo = new MovieList(movies);

        assertEquals(movieListOne, movieListTwo);
        assertEquals(movieListTwo, movieListOne);

        assertEquals(movieListOne.hashCode(), movieListTwo.hashCode());
    }

    @Test
    public void shouldCheckIfAMovieDoesNotExistInAListOfMovies() {
        movieList = new MovieList(movies);

        assertFalse(movieList.checkExistence("Head First Java"));
    }

    @Test
    public void shouldCheckIfAMovieExistInAListOfMovies() {
        movieList = new MovieList(movies);

        assertTrue(movieList.checkExistence("Movie1"));
    }

    @Test
    public void shouldBeAbleToIssueAnExistingMovieFromAListOfMovies() {
        movieList = new MovieList(movies);

        assertTrue(movieList.issueMovie("Movie1"));
    }

    @Test
    public void shouldNotIssueAMovieNotExistingInAListOfMovies() {
        movieList = new MovieList(movies);

        assertFalse(movieList.issueMovie("Movie11"));
    }
}