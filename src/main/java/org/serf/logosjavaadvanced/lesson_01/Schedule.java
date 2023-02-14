package org.serf.logosjavaadvanced.lesson_01;

import java.util.Set;
import java.util.TreeSet;

public class Schedule implements Comparable<Schedule> {

    private Set<Seance> seances = new TreeSet<>();

    public Schedule() {
    }

    public Schedule(Set<Seance> seances) {
        this.seances = seances;
    }

    public void addSeance(Seance seance){
        seances.add(seance);
    }

    public void removeSeance(Seance seance){
        seances.remove(seance);
    }

    public Set<Seance> getSeances() {
        return seances;
    }

    public void setSeances(Set<Seance> seances) {
        this.seances = seances;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "seances=" + seances +
                '}';
    }

    @Override
    public int compareTo(Schedule o) {
        return 0;
    }
}
