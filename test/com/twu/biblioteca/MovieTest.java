package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
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


    @Test
    public void testForComparingNullObjectsWithA() {
        Movie movie = new Movie("Movie Name", "Director Mane", 1999, "7/10");

        assertThat(movie, not(equalTo(null)));
    }

    @Test
    public void testForDifferentObjects() {
        Movie movie = new Movie("Movie Name", "Director Mane", 1999, "7/10");
        Object one = new Integer(1);

        assertThat(movie, not(equalTo(one)));
    }

    @Test
    public void testForEquality() {
        Movie movieOne = new Movie("Movie Name", "Director Mane", 1999, "7/10");
        Movie movieTwo = new Movie("Movie Name", "Director Mane", 1999, "7/10");


        assertEquals(movieOne, movieTwo);
    }

    @Test
    public void testForReflexivity() {
        Movie movie = new Movie("Movie Name", "Director Mane", 1999, "7/10");

        assertEquals(movie, movie);
    }

    @Test
    public void testForSymmetry() {        Movie movie = new Movie("Movie Name", "Director Mane", 1999, "7/10");
        Movie movieOne = new Movie("Movie Name", "Director Mane", 1999, "7/10");
        Movie movieTwo = new Movie("Movie Name", "Director Mane", 1999, "7/10");

        assertEquals(movieOne, movieTwo);
        assertEquals(movieTwo, movieOne);
    }

    @Test
    public void testForTransitivity() {
        Movie movieOne = new Movie("Movie Name", "Director Mane", 1999, "7/10");
        Movie movieTwo = new Movie("Movie Name", "Director Mane", 1999, "7/10");
        Movie movieThree = new Movie("Movie Name", "Director Mane", 1999, "7/10");

        assertEquals(movieOne, movieTwo);
        assertEquals(movieTwo, movieThree);
        assertEquals(movieThree, movieOne);
    }

    @Test
    public void equalityTestForHashCode() {
        Movie movieOne = new Movie("Movie Name", "Director Mane", 1999, "7/10");
        Movie movieTwo = new Movie("Movie Name", "Director Mane", 1999, "7/10");

        assertEquals(movieOne.hashCode(), movieTwo.hashCode());
    }

}