package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DispatcherTest {
    private Dispatcher dispatcher;

    @Before
    public void setUp() {
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
        User authorisedUser = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        CheckOutMovies checkOutMovies = new CheckOutMovies(consoleIO, movieList);
        ReturnMovie returnMovie = new ReturnMovie(consoleIO, movieList, authorisedUser);
        CheckOutBook checkOutBook = new CheckOutBook(consoleIO, new BookList(list), authorisedUser);
        ReturnBook returnBook = new ReturnBook(consoleIO, bookList, authorisedUser);
        Menu menu = new Menu();
        dispatcher = new Dispatcher(bookList, new Quit(), checkOutBook, returnBook, movieList, checkOutMovies, returnMovie, menu);

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

    @Test
    public void shouldDisplayListOfMoviesWhenUserGivesFive() {

        String actualOutput = dispatcher.computeMenuOption(5);
        String expectedOutput = String.format("%-40s", "Movie1") + String.format("%-40s", "Director1") +
                String.format("%-40s", 1999) + String.format("%-40s", "7/10") + System.lineSeparator() +
                String.format("%-40s", "Movie2") + String.format("%-40s", "Director2") +
                String.format("%-40s", 1998) + String.format("%-40s", "unrated") + System.lineSeparator();


        assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void shouldCallCheckoutActionWhenUserGivesThree() throws IOException {

        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList bookList = new BookList(list);
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "Director1", 1999, "7/10"));
        movies.add(new Movie("Movie2", "Director2", 1998, "unrated"));
        MovieList movieList = new MovieList(movies);
        when(consoleIO.read()).thenReturn("book1");

        User authorisedUser = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        CheckOutBook checkOutBook = new CheckOutBook(consoleIO, new BookList(list), authorisedUser);
        ReturnBook returnBook = new ReturnBook(consoleIO, bookList, authorisedUser);
        Menu menu = new Menu();
        CheckOutMovies checkOutMovies = new CheckOutMovies(consoleIO, movieList);
        ReturnMovie returnMovie = mock(ReturnMovie.class);

        dispatcher = new Dispatcher(bookList, new Quit(), checkOutBook, returnBook, movieList, checkOutMovies, returnMovie, menu);

        String actualOutput = dispatcher.computeMenuOption(3);
        String expectedOutput = "That book is not available.\n";

        assertThat(actualOutput, is(expectedOutput));
    }


    @Test
    public void shouldCallReturnBookActionWhenUserGivesFour() throws IOException {

        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList bookList = new BookList(list);
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "Director1", 1999, "7/10"));
        movies.add(new Movie("Movie2", "Director2", 1998, "unrated"));
        MovieList movieList = new MovieList(movies);
        when(consoleIO.read()).thenReturn("book1");
        User authorisedUser = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        CheckOutBook checkOutBook = new CheckOutBook(consoleIO, new BookList(list), authorisedUser);
        ReturnBook returnBook = new ReturnBook(consoleIO, bookList, authorisedUser);
        Menu menu = new Menu();
        CheckOutMovies checkOutMovies = new CheckOutMovies(consoleIO, movieList);
        ReturnMovie returnMovie = mock(ReturnMovie.class);

        dispatcher = new Dispatcher(bookList, new Quit(), checkOutBook, returnBook, movieList, checkOutMovies, returnMovie, menu);

        String actualOutput = dispatcher.computeMenuOption(4);
        String expectedOutput = "That is not a valid book to return\n";

        assertThat(actualOutput, is(expectedOutput));
    }


    @Test
    public void shouldCallCheckOutMovieActionWhenUserGivesSix() throws IOException {
        BookList bookList = mock(BookList.class);
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "Director1", 1999, "7/10"));
        movies.add(new Movie("Movie2", "Director2", 1998, "unrated"));
        MovieList movieList = new MovieList(movies);
        when(consoleIO.read()).thenReturn("Movie1");
        CheckOutBook checkOutBook = mock(CheckOutBook.class);
        ReturnBook returnBook = mock(ReturnBook.class);
        Menu menu = new Menu();
        CheckOutMovies checkOutMovies = new CheckOutMovies(consoleIO, movieList);
        ReturnMovie returnMovie = mock(ReturnMovie.class);
        dispatcher = new Dispatcher(bookList, new Quit(), checkOutBook, returnBook, movieList, checkOutMovies, returnMovie, menu);

        String actualOutput = dispatcher.computeMenuOption(6);
        String expectedOutput = "Thank you! Enjoy the movie.\n";

        assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void shouldCallReturnMovieActionWhenUserGivesSeven() throws IOException {
        BookList bookList = mock(BookList.class);
        ConsoleIO consoleIO = mock(ConsoleIO.class);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "Director1", 1999, "7/10"));
        movies.add(new Movie("Movie2", "Director2", 1998, "unrated"));
        MovieList movieList = new MovieList(movies);
        when(consoleIO.read()).thenReturn("Movie1");
        User authorisedUser = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        CheckOutBook checkOutBook = mock(CheckOutBook.class);
        ReturnBook returnBook = mock(ReturnBook.class);
        Menu menu = new Menu();
        CheckOutMovies checkOutMovies = new CheckOutMovies(consoleIO, movieList);
        ReturnMovie returnMovie = new ReturnMovie(consoleIO, movieList, authorisedUser);
        dispatcher = new Dispatcher(bookList, new Quit(), checkOutBook, returnBook, movieList, checkOutMovies, returnMovie, menu);

        String actualOutput = dispatcher.computeMenuOption(7);
        String expectedOutput = "That is not a valid movie to return\n";

        assertThat(actualOutput, is(expectedOutput));
    }
}