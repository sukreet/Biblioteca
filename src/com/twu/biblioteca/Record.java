package com.twu.biblioteca;

public class Record {
    private String userName;
    private String itemName;
    private String itemType;

    public Record(String userName, String itemName, String itemType) {
        this.userName = userName;
        this.itemName = itemName;
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return (String.format("%-40s", userName) +
                String.format("%-40s", itemName) +
                String.format("%-40s", itemType));
    }
}
