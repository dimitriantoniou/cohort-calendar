package com.edimitri.cohortcalendar.services;

import com.edimitri.cohortcalendar.models.Cohort;

import java.time.LocalDate;
import java.util.List;

public interface CalendarEventService {
    List<Cohort> getEvents(Cohort cohort);
}
