package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class BibliotecaFunctionalitiesTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void checkIfWelcomeMsgIsAsPerRequirement() {
        BibliotecaFunctionalities testWelcomeMsg = new BibliotecaFunctionalities();
        testWelcomeMsg.displayWelcomeMsg();

        assertEquals(outputStream.toString(), "Welcome" + System.lineSeparator());
    }

    @Test
    public void checkIfMainMenuIsAsPerRequirement() {
        BibliotecaFunctionalities testMainMenu = new BibliotecaFunctionalities();
        Menu menu = new Menu();
        testMainMenu.displayMenu(menu);


        String expectedMenuFormat = "Main Menu" + System.lineSeparator() + "1 : List Of Books" + System.lineSeparator()
                + "2 : Quit" + System.lineSeparator();

        assertEquals(expectedMenuFormat, outputStream.toString());
    }

    @Test
    public void checkIfInvalidMenuOptionIsAsPerRequirement() {
        BibliotecaFunctionalities testInvalidChoice = new BibliotecaFunctionalities();
        testInvalidChoice.invalidChoice();

        assertEquals(outputStream.toString(), "Select a valid option!" + System.lineSeparator());
    }


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}
