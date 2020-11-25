package com.edimitri.cohortcalendar.services;

import com.edimitri.cohortcalendar.models.CohortDay;
import com.edimitri.cohortcalendar.models.Holiday;
import com.edimitri.cohortcalendar.models.Holidays;
import com.edimitri.cohortcalendar.repositories.HolidaysRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CohortCalendarServiceImpl implements CohortCalendarService{
    private final HolidaysRepository holidaysRepository;
    public CohortCalendarServiceImpl(HolidaysRepository holidaysRepository){
        this.holidaysRepository=holidaysRepository;
    }

    @Override
    public List<CohortDay> getCalendar(LocalDate startDate){
        System.out.println("startDate.getDayOfWeek()= " +startDate.getDayOfWeek());

        List<CohortDay> results = new ArrayList<>();
        LocalDate currentDate=startDate;
        double totalHours=0;
        while (totalHours<670){
            Holidays holiday=getHolidayByDate(currentDate);
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


    public Holidays getHolidayByDate(LocalDate date) {
        return holidaysRepository.findFirstByDate(date);
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
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dayOfWeek);
        }

        return dayHours;
    }

}
