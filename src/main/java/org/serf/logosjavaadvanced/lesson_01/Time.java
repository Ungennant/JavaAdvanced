package org.serf.logosjavaadvanced.lesson_01;

import java.util.Objects;

public class Time implements Comparable<Time> {

    private int min;
    private int hour;

    public Time(int hour) {
        this.hour = hour;
    }

    public Time(int min, int hour) throws IllegalAccessException {
        if((min >= 0 && min < 60) && (hour >= 0 && hour < 24)) {
            this.min = min;
            this.hour = hour;
        } else {
            throw new IllegalAccessException();
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;
        Time time = (Time) o;
        return min == time.min && hour == time.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, hour);
    }

    @Override
    public String toString() {
        return this.hour + ":" + this.min;
    }

    public static Time sumTimes(Time t1, Time t2) throws IllegalAccessException {

        int newMin = t1.getMin() + t2.getMin();
        int newHour = t1.getHour() + t2.getHour();

        return new Time(newMin, newHour);
    }

    @Override
    public int compareTo(Time o) {
        return (hour * 60 + min) - (o.getHour() * 60 + o.getMin());
    }
}
