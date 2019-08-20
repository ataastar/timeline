package com.example.myfirstapp.bean;

import java.util.ArrayList;
import java.util.List;

public class Timeline {

    public Timeline(Week week) {
        this.week = week;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    private Week week;
    private List<Day> days = new ArrayList<>();
    public void addDay(Day day) {
        days.add(day);
    }

    public enum Week {
        A, B, C;

        public Week next() {
            int ordinal = ordinal() + 1;
            if (ordinal >= values().length) {
                return null;
            }
            return values()[ordinal];
        }
    }

}
