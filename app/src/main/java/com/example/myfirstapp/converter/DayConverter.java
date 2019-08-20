package com.example.myfirstapp.converter;

import com.example.myfirstapp.bean.Day;

import java.util.Collections;
import java.util.List;

public class DayConverter {
    public Day convert(String text) {
        if (text == null) {
            return null;
        }
        Day day = new Day();
        String[] rawLessons = text.split(",");
        for (String rawLesson : rawLessons) {
            day.addLesson(Day.Lesson.parse(rawLesson));
        }
        return day;
    }
}
