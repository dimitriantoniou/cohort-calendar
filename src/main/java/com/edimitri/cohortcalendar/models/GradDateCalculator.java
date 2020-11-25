package com.edimitri.cohortcalendar.models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

public class GradDateCalculator {

    public static void main(String[] args) {
        double totalHours=0;

        //start with cohort start date
        /*LocalDate currentDate = cohort.startDate.toInstant().instant.atZone(defaultZoneId).toLocalDate();

         */
        //while program totalhours is less than to contact hours
        // while(cohort.totalHours<=cohort.contactHours){

        //if date matches holiday list, break and continue;
        //Holiday holiday = getHOlidayByDate(currentDate());
        /*
        String holiday = holiday.getHolidayDate();
        Holiday existingHoliday = holidayRepository.findByDate(holidayDate);
        if(existingHoliday != null){
            continue;
        }


    }*/
        //else, get the hours value for the date that is being passed in
        /*
        java.time.DayOfWeek dayOfWeek = ld.getDayOfWeek();
        double dayHours;
        switch (dayOfWeek) {
            case MONDAY:
            case FRIDAY:
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
            case SATURDAY:
            case SUNDAY:
                dayHours = 0;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + dayOfWeek);


        }
        */
        //add dayHours to totalHours
            /*totalHours+= dayHours*/
        //set cohort endDate = currentDate
            // cohort.endDate=currentDate
        //move forward 1 day i.e. add 1 current date
            /*currentDate.plus(1);*/


        //
    }
}