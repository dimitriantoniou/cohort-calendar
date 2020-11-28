package com.edimitri.cohortcalendar.repositories;

import com.edimitri.cohortcalendar.models.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CohortScheduleRepository extends JpaRepository<Cohort, Long> {
    Cohort findByName(String name);
}
