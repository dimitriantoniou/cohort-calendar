package com.edimitri.cohortcalendar.repositories;

import com.edimitri.cohortcalendar.models.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CohortRepository extends JpaRepository<Cohort,Long> {
    Cohort findByName(String name);

    List<Cohort> findAll();

    @Query("from Cohort a where a.name like %:name%")
    List<Cohort> findCohortsByName(@Param("name") String name);

}
