package com.edimitri.cohortcalendar.models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

public class GradDateCalculator {

    public static void main(String[] args) {

        //get the hours value for the date that is being passed in
        LocalDate ld = LocalDate.of(2021, 01, 01);
        java.time.DayOfWeek dayOfWeek = ld.getDayOfWeek();
        double dayHours;
        switch (dayOfWeek) {
            case MONDAY:
                dayHours = 7;
                break;
            case TUESDAY:
                dayHours = 6;
                break;
            case WEDNESDAY:
                dayHours = 3.5;
                break;
            case THURSDAY:
                dayHours = 6.5;
                break;
            case FRIDAY:
                dayHours = 7;
                break;
            case SATURDAY:
                dayHours = 0;
                break;
            case SUNDAY:
                dayHours = 0;
            default:
                throw new IllegalStateException("Unexpected value: " + dayOfWeek);
        }
        System.out.println("This day had " + dayHours + " hours in it.");

        //
    }
}