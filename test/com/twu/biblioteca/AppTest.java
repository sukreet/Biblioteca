package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


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
        CheckOut checkOut = new CheckOut(bufferedReader, new Books(list));
        App app = new App(new Menu(new Books(list), new Quit(),checkOut));

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
        CheckOut checkOut = new CheckOut(bufferedReader, new Books(list));

        App app = new App(new Menu(new Books(list), new Quit(),checkOut));

        app.displayMenu();


        String expectedMenuFormat = "Main Menu" + System.lineSeparator() + "1 : List Of Books" + System.lineSeparator()
                + "2 : Quit" + System.lineSeparator() + "3 : Checkout Book" + System.lineSeparator();

        assertEquals(expectedMenuFormat, outputStream.toString());
    }
//
//    @Test
//    public void shouldNotContinueLoopIfTheUserSelectsQuit() {
//       ByteArrayInputStream inputStream = new ByteArrayInputStream("2".getBytes());
//        System.setIn(inputStream);
//        Menu menuStub = mock(Menu.class);
//       Menu menu = mock(Menu.class);
//
//
//        App bibliotecaFunctionalities = new App();
//        bibliotecaFunctionalities.start(menuStub);
//
//        verify(menuStub).performAction(2);
//    }


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}
