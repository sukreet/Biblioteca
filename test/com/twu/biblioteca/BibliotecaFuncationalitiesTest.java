package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaFuncationalitiesTest {

    private  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void stUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void checkIfWelcomeMsgIsAsPerRequirement() {
        BibliotecaFuncationalities testWelcomeMsg = new BibliotecaFuncationalities();
        testWelcomeMsg.displayWelcomeMsg();

        assertEquals(outputStream.toString(), "Welcome" + System.lineSeparator());
    }


}
