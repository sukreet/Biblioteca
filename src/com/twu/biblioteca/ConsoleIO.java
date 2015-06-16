package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleIO {
    BufferedReader bufferedReader;

    public ConsoleIO(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int readInt() throws IOException {
        String st = bufferedReader.readLine();
        return Integer.parseInt(st);

    }

    public String read() throws IOException {
        return bufferedReader.readLine();
    }

    public void display(String output) {
        System.out.print(output);
    }
}
