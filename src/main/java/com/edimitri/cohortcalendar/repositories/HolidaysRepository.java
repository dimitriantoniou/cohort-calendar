package com.edimitri.cohortcalendar.repositories;

import com.edimitri.cohortcalendar.models.Holiday;
import com.edimitri.cohortcalendar.models.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface HolidaysRepository extends JpaRepository<Holidays, Long> {
    Holidays findFirstByDate(LocalDate date);
}
