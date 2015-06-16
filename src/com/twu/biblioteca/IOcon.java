package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

public class IOcon {
    BufferedReader bufferedReader;

    public IOcon(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int readInt() throws IOException {
        String st = bufferedReader.readLine();
        return Integer.parseInt(st);

    }
}
