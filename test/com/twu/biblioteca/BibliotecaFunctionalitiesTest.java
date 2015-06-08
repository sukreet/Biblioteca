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
        testMainMenu.displayMenu();

        String expectedMenuFormat = "Main Menu" + System.lineSeparator() + "1. List books" + System.lineSeparator();

        assertEquals(outputStream.toString(), expectedMenuFormat);
    }


    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

}
