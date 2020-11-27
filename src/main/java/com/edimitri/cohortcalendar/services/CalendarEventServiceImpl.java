package com.edimitri.cohortcalendar.services;

import com.edimitri.cohortcalendar.models.Cohort;
import com.edimitri.cohortcalendar.models.Event;
import com.edimitri.cohortcalendar.repositories.CohortRepository;
import com.edimitri.cohortcalendar.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarEventServiceImpl implements CalendarEventService {
    //this service should create or update an calendar event for each cohort
    private final EventRepository eventRepository;

    public CalendarEventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getEvents(LocalDate start, LocalDate end, String title) {
        List<Event> events = new ArrayList<>();
        events.add(new Event(start, end, title));
        return events;
    }
}
