package com.edimitri.cohortcalendar.services;

import com.edimitri.cohortcalendar.models.Cohort;
import com.edimitri.cohortcalendar.repositories.CohortRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarEventServiceImpl implements CalendarEventService {
    //this service should create or update an calendar event for each cohort

    private final CohortRepository cohortRepository;

    public CalendarEventServiceImpl(CohortRepository cohortRepository) {
        this.cohortRepository = cohortRepository;
    }

    @Override
    public List<Cohort> getEvents(Cohort cohort) {
        List<Cohort> events = new ArrayList<>();
        LocalDate start = cohort.getStartDate();
        LocalDate end = cohort.getGradDate();
        String name = cohort.getName();
        String campus = cohort.getCampus();
        double hours = cohort.getContactHours();
        String program = cohort.getProgramType();

        events.add(new Cohort(name, start, program, campus, hours));
        return events;
    }
}
