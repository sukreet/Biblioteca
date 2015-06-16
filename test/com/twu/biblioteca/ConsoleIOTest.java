package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleIOTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private ConsoleIO consoleIO;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldReadIntCorrectly() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1");
        consoleIO = new ConsoleIO(bufferedReader);

        assertEquals(consoleIO.readInt(), 1);
    }

    @Test
    public void shouldReadStringCorrectly() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("hello ");
        consoleIO = new ConsoleIO(bufferedReader);

        assertEquals(consoleIO.read(), "hello ");
    }

    @Test
    public void shouldPrintCorrectly() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        consoleIO = new ConsoleIO(bufferedReader);
        consoleIO.display("hola");

        assertEquals(outputStream.toString(), "hola");

    }
}