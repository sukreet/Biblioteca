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

public class IOconTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private IOcon iOcon;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldReadIntCorrectly() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1");
        iOcon = new IOcon(bufferedReader);

        assertEquals(iOcon.readInt(), 1);

    }

    @Test
    public void shouldReadStringCorrectly() throws IOException {

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("hello ");
        iOcon = new IOcon(bufferedReader);

        assertEquals(iOcon.read(), "hello ");

    }
}