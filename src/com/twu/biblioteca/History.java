package com.twu.biblioteca;

import java.util.ArrayList;

public class History {
    private ArrayList<Record> records;

    public History() {
        records = new ArrayList<>();
    }

    public String show() {
        return "No records to show\n";

    }

}
