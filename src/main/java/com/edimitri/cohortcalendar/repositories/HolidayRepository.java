package com.edimitri.cohortcalendar.repositories;

import com.edimitri.cohortcalendar.models.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface HolidayRepository extends JpaRepository<Holiday,Long> {
    Holiday findFirstByDate(LocalDate date);
    //see Defining Query Methods lesson in curriculum
}
