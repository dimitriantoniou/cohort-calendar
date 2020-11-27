package com.edimitri.cohortcalendar.models;

import java.time.LocalDate;

public class Event {

    private LocalDate start;
    private LocalDate end;
    private String title;

    public Event(LocalDate start, LocalDate end, String title) {
        this.start = start;
        this.end = end;
        this.title = title;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
