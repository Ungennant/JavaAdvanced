package org.serf.logosjavaadvanced.lesson_01;

import java.util.*;

public class Cinema {

    private TreeMap<Days, Schedule> schedules = new TreeMap<>();
    private List<Movie> moviesLibrary = new ArrayList<>();
    private Time open;
    private Time close;

    public Cinema(Time open, Time close) {
        this.open = open;
        this.close = close;
    }

    public void addMovie(Movie movie, Time...time) throws IllegalAccessException {
        moviesLibrary.add(movie);
        for (int i = 0; i < time.length ; i++) {
            for (int j = 0; j < Days.values().length; j++) {
                schedules.get(Days.values()[j]).addSeance(new Seance(movie, time[i]));
            }
        }
        System.out.println("Movie ADDED successfully.");
    }

    public void removeMovie(Movie movie) {
        moviesLibrary.remove(movie);
            System.out.println("Movie REMOVED successfully.");

    }

    public void addSeance(Seance seance, String day) {
        if ((seance.getStartTime().getHour() >= open.getHour()) && (seance.getEndTime().getHour() < close.getHour())) {
            Optional<Map.Entry<Days, Schedule>> scheduleEntry = schedules.entrySet().stream()
                    .filter(element -> element.getKey().equals(day)).findFirst();
            if (scheduleEntry.isPresent()) {
                scheduleEntry.get().getValue().addSeance(seance);
                System.out.println("Seance ADDED successfully.");
            }
        } else {
            System.out.println("Cant add seance when Cinema is closed.");
        }
    }

    public void removeSeance(Seance seance, String day) {
        if (schedules.containsValue(seance) & schedules.containsKey(day)) {
            schedules.remove(day);
        } else {
            System.out.println("No such seance in schedule");
        }
        System.out.println("Seance REMOVED successfully.");
    }

    public TreeMap<Days, Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(TreeMap<Days, Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Movie> getMoviesLibrary() {
        return moviesLibrary;
    }

    public void setMoviesLibrary(List<Movie> moviesLibrary) {
        this.moviesLibrary = moviesLibrary;
    }

    public Time getOpen() {
        return open;
    }

    public void setOpen(Time open) {
        this.open = open;
    }

    public Time getClose() {
        return close;
    }

    public void setClose(Time close) {
        this.close = close;
    }

    public static Movie findMovieByName(Cinema cinema) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter movie title to find:");
        String movieTittle = scanner.next();
        Movie movie = null;
        try {
            movie = cinema.getMoviesLibrary().stream().filter(element -> element.getTittle().equalsIgnoreCase(movieTittle))
                    .findFirst().get();
        } catch (NoSuchElementException e){
            System.out.println("Movie not found. Please put correct tittle.");
        }
        return movie;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "schedules=" + schedules +
                ", moviesLibrary=" + moviesLibrary +
                '}';
    }
}
