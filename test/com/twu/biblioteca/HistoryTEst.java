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

}
