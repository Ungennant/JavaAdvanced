package org.serf.logosjavaadvanced.lesson_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema(new Time(0, 10), new Time(0, 22));

        while (true){
            appMenu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter movie title:");
                    String tittle = scanner.next();
                    System.out.println("Add movie duration");
                    System.out.println("Enter minutes:");
                    int minutes = scanner.nextInt();
                    System.out.println("Enter hours:");
                    int hours = scanner.nextInt();
                    System.out.println();
                    cinema.addMovie(new Movie(tittle, new Time(minutes, hours)));
                    break;
                case 2:
                    Movie movieToRemove = Cinema.findMovieByName(cinema);
                    cinema.removeMovie(movieToRemove);
                    break;
                case 3:
                    System.out.println("Enter movie name to add seance:");
                    Movie movie = Cinema.findMovieByName(cinema);
                    System.out.println("Enter start hour");
                    int startHour = scanner.nextInt();
                    Seance seance = new Seance(movie, new Time(startHour));
                    System.out.println("Enter seance day to add:");
                    String day = scanner.next().toUpperCase(Locale.ROOT);

                    cinema.addSeance(seance,day);
                    break;
                case 4:
                    System.out.println("Choose seance to remove:");
                    System.out.println("Enter day:");
                    String seanceDay = scanner.next();
                    Schedule schedule = cinema.getSchedules().get(Days.valueOf(seanceDay));
                    List<Seance> seanceList = new ArrayList<>();
                    for (int i = 0; i < seanceList.size(); i++) {
                        System.out.println(i + " : " + seanceList.get(i));
                    }
                    int seanceId = scanner.nextInt();
                    Seance seanceToRemove = seanceList.get(seanceId);
                    cinema.removeSeance(seanceToRemove, seanceDay);
                    break;
                case 5:
                    System.out.println(cinema.getMoviesLibrary());
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Wrong choice, please try again!!!");
            }

        }
    }

    public static void appMenu(){
        System.out.println("_________________");
        System.out.println("1. Add movie");
        System.out.println("2. Remove movie");
        System.out.println("3. Add seance");
        System.out.println("4. Remove seance");
        System.out.println("5. See schedule");
        System.out.println("6. Exit");
        System.out.println("_________________");
        System.out.println("Please, choose one of above:");
    }
}
