import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.serf.logosjavaadvanced.lesson_01.Cinema;
import org.serf.logosjavaadvanced.lesson_01.Movie;
import org.serf.logosjavaadvanced.lesson_01.Time;

import java.util.ArrayList;
import java.util.List;

public class CinemaTest {

    private static Cinema cinema;
    private static Movie movie;
    private static List<Movie> movieList;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println("SUCCEED-->" + description.getMethodName());
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("FAILED-->" + description.getMethodName());
        }
    };

    @BeforeClass
    public static void beforeTest() throws IllegalAccessException {
        cinema = new Cinema(new Time(15,10), new Time(30,20));
        movie = new Movie("Batman", new Time(20,2));
        movieList = new ArrayList<>();
        movieList.add(movie);
    }

    @AfterClass
    public static void afterTest(){
        movie = null;
    }

    @Test
    public void addMovieTest() throws IllegalAccessException {
        movieList.add(movie);
        cinema.addMovie(movie);
        Assert.assertEquals(movieList, cinema.getMoviesLibrary());
    }

    @Test
    public void removeMovieTest(){
        cinema.removeMovie(movie);
        movieList.remove(movie);
        Assert.assertEquals(movieList, cinema.getMoviesLibrary());
    }

//    @Test
//    public void findMovieByNameTest(){
//
//    }



}
