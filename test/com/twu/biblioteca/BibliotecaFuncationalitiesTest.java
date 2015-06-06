package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class BibliotecaFuncationalitiesTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void checkIfWelcomeMsgIsAsPerRequirement() {
        BibliotecaFuncationalities testWelcomeMsg = new BibliotecaFuncationalities();
        testWelcomeMsg.displayWelcomeMsg();

        assertEquals(outputStream.toString(), "Welcome" + System.lineSeparator());
    }

    @Test
    public void checkIfBookListIsreturnedasExpected() {
        BibliotecaFuncationalities testBookList = new BibliotecaFuncationalities();
        testBookList.displayBookList();

        String expectedBookList = "Book1" + System.lineSeparator() + "Book2" + System.lineSeparator() + "Book3" + System.lineSeparator();

        assertEquals(outputStream.toString(), expectedBookList);
    }


}
