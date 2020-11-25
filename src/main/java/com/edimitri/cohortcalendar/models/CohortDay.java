package com.edimitri.cohortcalendar.models;

import java.time.LocalDate;

public class CohortDay {
    private double hours;
    private LocalDate holidayDate;
    private Holidays holiday;

    public CohortDay(double hours, LocalDate holidayDate, Holidays holiday) {
        this.hours = hours;
        this.holidayDate = holidayDate;
        this.holiday = holiday;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public LocalDate getHolidayDate() {
        return holidayDate;
    }

    public void setDate(LocalDate holidayDate) {
        this.holidayDate = holidayDate;
    }

    public Holidays getHoliday() {
        return holiday;
    }

    public void setHoliday(Holidays holiday) {
        this.holiday = holiday;
    }
}
