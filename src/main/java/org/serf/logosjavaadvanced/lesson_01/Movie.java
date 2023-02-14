package org.serf.logosjavaadvanced.lesson_01;

import java.util.Objects;

public class Movie {

    private String tittle;
    private Time duration;

    public Movie(String tittle, Time duration) {
        this.tittle = tittle;
        this.duration = duration;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(tittle, movie.tittle) && Objects.equals(duration, movie.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tittle, duration);
    }

    @Override
    public String toString() {
        return "Movie title: " + this.tittle + "\n Movie duration: " + this.duration;
    }
}
