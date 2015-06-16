package com.twu.biblioteca;


public class Movie {
    private String director;
    private String name;
    private int yearOfRelease;
    private String rating;
    private Boolean isAvailable;

    public Movie(String name, String director, int yearOfRelease, String rating) {
        this.director = director;
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return (String.format("%-40s", name) + String.format("%-40s", director) + String.format("%-40s", yearOfRelease) + String.format("%-40s", rating));
    }
}