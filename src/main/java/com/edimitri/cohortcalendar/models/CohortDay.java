package com.edimitri.cohortcalendar.models;

import java.time.LocalDate;

public class CohortDay {
    private double hours;
    private LocalDate date;
    private Holiday holiday;

    public CohortDay(double hours, LocalDate date, Holiday holiday) {
        this.hours = hours;
        this.date = date;
        this.holiday = holiday;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
}
