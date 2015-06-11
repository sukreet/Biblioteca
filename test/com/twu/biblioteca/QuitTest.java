package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuitTest {
    @Test
    public void shouldReturnNullValue() {
        Quit quit = new Quit();

        String result = quit.toString();

        assertEquals(" ", result);

    }
}
