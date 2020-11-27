package com.edimitri.cohortcalendar.services;

import com.edimitri.cohortcalendar.models.Cohort;
import com.edimitri.cohortcalendar.models.Event;

import java.time.LocalDate;
import java.util.List;

public interface CalendarEventService {
    List<Event> getEvents(LocalDate start, LocalDate end, String title);
}
