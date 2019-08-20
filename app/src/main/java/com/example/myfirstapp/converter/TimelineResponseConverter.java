package com.example.myfirstapp.converter;

import com.example.myfirstapp.bean.Day;
import com.example.myfirstapp.bean.Timeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimelineResponseConverter {

    public List<Timeline> convert(String text) {
        if (text == null) {
            return Collections.emptyList();
        }
        DayConverter dayConverter = new DayConverter();
        List<Timeline> timelines = new ArrayList<>();
        Timeline timeline = new Timeline(Timeline.Week.A);
        String[] rawDays = text.split("\\r?\\n");
        int dayCount = 0;
        for (String rawDay : rawDays) {
            dayCount++;
            if (dayCount > 5) {
                timelines.add(timeline);
                timeline = new Timeline(timeline.getWeek().next());
            }
            Day day = dayConverter.convert(rawDay);
            timeline.addDay(day);
        }
        timelines.add(timeline);
        return timelines;
    }
}
