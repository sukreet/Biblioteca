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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (yearOfRelease != movie.yearOfRelease) return false;
        if (!director.equals(movie.director)) return false;
        if (!name.equals(movie.name)) return false;
        return rating.equals(movie.rating);

    }

    @Override
    public int hashCode() {
        int result = director.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + yearOfRelease;
        result = 31 * result + rating.hashCode();
        return result;
    }
    public boolean checkNameIs(String name) {
        return name.equals(this.name);
    }

}