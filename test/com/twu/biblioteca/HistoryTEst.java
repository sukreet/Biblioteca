package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HistoryTest {

    @Test
    public void shouldBeAbleToShowProperMsgNoRecordsToDisplay() {
        History history = new History();

        String actualMsg = history.show();
        String expectedMsg = "No records to show\n";

        assertEquals(expectedMsg, actualMsg);
    }

    @Test
    public void shouldBeAbleToAddNewRecordAndDisplany() {
        History history = new History();
        history.addRecord("Sukreet", "Macbeth", "Book");
        history.addRecord("Sourav", "Movie1", "Movie");

        String actualMsg = history.show();
        String expectedMsg = String.format("%-40s", "Sukreet") + String.format("%-40s", "Macbeth") + String.format("%-40s", "Book") + System.lineSeparator() +
                String.format("%-40s", "Sourav") + String.format("%-40s", "Movie1") + String.format("%-40s", "Movie") + System.lineSeparator();

        assertEquals(expectedMsg, actualMsg);


    }
}
