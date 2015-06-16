package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class DispatcherTest {
    private Dispatcher dispatcher;

    @Before
    public void setuo() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        BookList bookList = new BookList(list);
        ConsoleIO consoleIO = new ConsoleIO(bufferedReader);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "Director1", 1999, "7/10"));
        movies.add(new Movie("Movie2", "Director2", 1998, "unrated"));
        MovieList movieList = new MovieList(movies);


        CheckOut checkOut = new CheckOut(consoleIO, bookList);
        ReturnBook returnBook = new ReturnBook(consoleIO, bookList);
        Menu menu = new Menu();
        dispatcher = new Dispatcher(bookList, new Quit(), checkOut, returnBook, movieList , menu);

    }

    @Test
    public void shouldDisplayListOfBooksWhenUserGivesOne() {

        String actualOutput = dispatcher.computeMenuOption(1);
        String expectedOutput = String.format("%-40s", "Head First Java") + String.format("%-40s", "Kathy") + String.format("%-40s", 1995) + System.lineSeparator()
                + String.format("%-40s", "Learning C") + String.format("%-40s", "John") + String.format("%-40s", 2000) + System.lineSeparator();

        assertThat(actualOutput, is(expectedOutput));
    }


    @Test
    public void shouldDisplayInvalidMenuOptionWhenIncorrectMenuOptionIsPassed() {

        String actualOutput = dispatcher.computeMenuOption(8);

        assertThat(actualOutput, is("Select a valid option!"));
    }

}