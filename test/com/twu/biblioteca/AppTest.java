package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;


public class AppTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private App app;


    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        BookList bookList = new BookList(list);
        ConsoleIO consoleIO = new ConsoleIO(bufferedReader);
        CheckOut checkOut = new CheckOut(consoleIO, bookList);
        ReturnBook returnBook = new ReturnBook(consoleIO, bookList);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "Director1", 1999, "7/10"));
        movies.add(new Movie("Movie2", "Director2", 1998, "unrated"));
        MovieList movieList = new MovieList(movies);

        Menu menu = new Menu();
        Dispatcher dispatcher = new Dispatcher(bookList, new Quit(), checkOut, returnBook, movieList, menu);
        app = new App(dispatcher, menu, consoleIO);

    }

    @Test
    public void checkIfWelcomeMsgIsAsPerRequirement() {

        app.displayWelcomeMessage();

        assertEquals(outputStream.toString(), "Welcome" + System.lineSeparator());
    }

    @Test
    public void checkIfMainMenuIsAsPerRequirement() {

        app.displayMenu();


        String expectedMenuFormat = "Main Menu" + System.lineSeparator() +
                "1 : List Of Books" + System.lineSeparator() +
                "2 : Quit" + System.lineSeparator() +
                "3 : Checkout Book" + System.lineSeparator() +
                "4 : Return Book" + System.lineSeparator() +
                "5 : List Of Movies" + System.lineSeparator();
        ;


        assertEquals(expectedMenuFormat, outputStream.toString());
    }

//    @Test
//    public void shouldNotContinueLoopIfTheUserSelectsQuit() throws IOException {
//        ConsoleIO io = mock(ConsoleIO.class);
//        when(io.readInt()).thenReturn(2);
//
//        app.start();
//
//        assertTrue(true);
//    }



    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}
