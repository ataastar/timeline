package com.example.myfirstapp.bean;

import java.util.ArrayList;
import java.util.List;

public class Day {

    public enum Lesson {
        MATH("Matek"), PE("Tesi"), GRAMMAR("Nyelvtan"), SING("Ének"),
        HISTORY("Töri"), LITERATURE("Irodalom"), ENGLISH("Angol"), DRAW("Rajz"),
        NATURE("Természet");

        private String key;

        Lesson(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static Lesson parse(String lessonKey) {
            for( Lesson lesson : Lesson.values()) {
                if(lesson.getKey().equals(lessonKey)) {
                    return lesson;
                }
            }
            return null;
        }
    }

    private List<Lesson> lessons = new ArrayList<>();
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }
}
