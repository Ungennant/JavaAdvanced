import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.serf.logosjavaadvanced.lesson_01.Movie;
import org.serf.logosjavaadvanced.lesson_01.Schedule;
import org.serf.logosjavaadvanced.lesson_01.Seance;
import org.serf.logosjavaadvanced.lesson_01.Time;

import java.util.Set;
import java.util.TreeSet;

public class ScheduleTest {

    private static Schedule schedule;
    private static Movie movie;
    private static  Seance seance;
    private static Set<Seance> seanceSet;

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
        schedule = new Schedule();
        movie = new Movie("Rush Hour", new Time(45,3));
        seance = new Seance(movie, new Time(14));
        seanceSet = new TreeSet<>();
        seanceSet.add(seance);
    }

    @AfterClass
    public static void afterTest(){
        schedule = null;
    }

    @Test
    public void addSeanceTest(){
                schedule.addSeance(seance);
        Assert.assertEquals(seanceSet, schedule.getSeances());
    }

    @Test
    public void removeSeanceTest(){
           seanceSet.remove(seance);
           schedule.removeSeance(seance);
           Assert.assertEquals(seanceSet, schedule.getSeances());
    }

}
