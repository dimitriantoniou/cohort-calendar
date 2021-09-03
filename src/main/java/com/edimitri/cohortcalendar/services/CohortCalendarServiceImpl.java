package com.edimitri.cohortcalendar.services;

import com.edimitri.cohortcalendar.models.CohortDay;
import com.edimitri.cohortcalendar.models.Holiday;
import com.edimitri.cohortcalendar.repositories.HolidayRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CohortCalendarServiceImpl implements CohortCalendarService{
    private final HolidayRepository holidayRepository;

    public CohortCalendarServiceImpl(HolidayRepository holidayRepository){
        this.holidayRepository=holidayRepository;
    }

    @Override
    public List<CohortDay> getCalendar(LocalDate startDate, double contactHours){
        System.out.println("startDate.getDayOfWeek()= " +startDate.getDayOfWeek());

        List<CohortDay> results = new ArrayList<>();
        LocalDate currentDate=startDate;
        double totalHours=0;
        while (totalHours<contactHours){
            Holiday holiday = getHolidayByDate(currentDate);
            double dayHours=0;
            if(holiday==null){
                dayHours=getHoursOfDayofWeek(currentDate.getDayOfWeek());
            }
            totalHours+=dayHours;
            results.add(new CohortDay(dayHours, currentDate, holiday));
            currentDate=currentDate.plusDays(1);
        }
        return results;
    }


    public Holiday getHolidayByDate(LocalDate date) {
        return holidayRepository.findFirstByDate(date);
    }

    public static double getHoursOfDayofWeek(DayOfWeek dayOfWeek) {
        double dayHours;
        switch (dayOfWeek) {
            case MONDAY:
                dayHours = 7;
                break;
            case TUESDAY:
                dayHours = 6;
                break;
            case WEDNESDAY:
                dayHours = 7; // 3.5 Hours for 1/2 Day Wednesdays or 7 for full day
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
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dayOfWeek);
        }

        return dayHours;
    }

}
