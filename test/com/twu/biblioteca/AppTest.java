package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;


public class AppTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void checkIfWelcomeMsgIsAsPerRequirement() {
        App testWelcomeMsg = new App();
        testWelcomeMsg.displayWelcomeMessage();

        assertEquals(outputStream.toString(), "Welcome" + System.lineSeparator());
    }

    @Test
    public void checkIfMainMenuIsAsPerRequirement() {
        App testMainMenu = new App();
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Learning C", "John", 2000));

        Menu menu = new Menu(new Books(books));
        testMainMenu.displayMenu(menu);


        String expectedMenuFormat = "Main Menu" + System.lineSeparator() + "1 : List Of Books" + System.lineSeparator()
                + "2 : Quit" + System.lineSeparator();

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
//        verify(menuStub).computeMenuOption(2);
//    }


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}
