package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class BibliotecaOutputHandlerTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void checkIfWelcomeMsgIsAsPerRequirement() {
        BibliotecaOutputHandler testWelcomeMsg = new BibliotecaOutputHandler();
        testWelcomeMsg.displayWelcomeMsg();

        assertEquals(outputStream.toString(), "Welcome" + System.lineSeparator());
    }

    @Test
    public void checkIfMainMenuIsAsPerRequirement() {
        BibliotecaOutputHandler testMainMenu = new BibliotecaOutputHandler();
        Menu menu = new Menu();
        testMainMenu.displayMenu(menu);


        String expectedMenuFormat = "Main Menu" + System.lineSeparator() + "1 : List Of Books" + System.lineSeparator()
                + "2 : Quit" + System.lineSeparator();

        assertEquals(expectedMenuFormat, outputStream.toString());
    }


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}
