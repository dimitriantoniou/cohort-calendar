package com.edimitri.cohortcalendar.services;

import com.edimitri.cohortcalendar.models.CohortDay;

import java.time.LocalDate;
import java.util.List;

public interface CohortCalendarService {
    List<CohortDay> getCalendar(LocalDate startDate);
}
