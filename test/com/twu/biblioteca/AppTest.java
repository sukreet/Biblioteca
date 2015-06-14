package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AppTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void checkIfWelcomeMsgIsAsPerRequirement() {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        Books books = new Books(list);
        CheckOut checkOut = new CheckOut(bufferedReader, books);
        ReturnBook returnBook = new ReturnBook(bufferedReader, books);
        App app = new App(new Menu(books, new Quit(), checkOut, returnBook));

        app.displayWelcomeMessage();

        assertEquals(outputStream.toString(), "Welcome" + System.lineSeparator());
    }

    @Test
    public void checkIfMainMenuIsAsPerRequirement() {

        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        Books books = new Books(list);
        CheckOut checkOut = new CheckOut(bufferedReader, books);
        ReturnBook returnBook = new ReturnBook(bufferedReader, books);
        App app = new App(new Menu(books, new Quit(), checkOut, returnBook));

        app.displayMenu();


        String expectedMenuFormat = "Main Menu" + System.lineSeparator() + "1 : List Of Books" + System.lineSeparator()
                + "2 : Quit" + System.lineSeparator() + "3 : Checkout Book" + System.lineSeparator()+ "4 : Return Book" + System.lineSeparator();

        assertEquals(expectedMenuFormat, outputStream.toString());
    }


    @Test
    public void shouldNotContinueLoopIfTheUserSelectsQuit() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("2");

        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        Books books = new Books(list);
        CheckOut checkOut = new CheckOut(bufferedReader, books);
        ReturnBook returnBook = new ReturnBook(bufferedReader, books);
        App app = new App(new Menu(books, new Quit(), checkOut, returnBook));

        app.start(bufferedReader);
        assertTrue(true);

    }


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}
