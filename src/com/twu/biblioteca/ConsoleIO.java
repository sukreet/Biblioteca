package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

import static java.lang.Character.isDigit;

public class ConsoleIO {
    BufferedReader bufferedReader;

    public ConsoleIO(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int readInt() throws IOException {
        String st = bufferedReader.readLine();
        if (st.length() == 1 && isDigit(st.charAt(0)) )
            return Integer.parseInt(st);
        return 0;
    }

    public String read() throws IOException {
        return bufferedReader.readLine();
    }

    public void display(String output) {
        System.out.print(output);
    }
}
