package com.edimitri.cohortcalendar.repositories;

import com.edimitri.cohortcalendar.models.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CohortRepository extends JpaRepository<Cohort,Long> {
    Cohort findByName(String name);
    Cohort findByCampusAndProgramType(String campus, String programType);

    List<Cohort>findByProgramType(String programType);
    List<Cohort>findByProgramType();

    List<Cohort> findByCampus(String campus);
    List<Cohort> findByCampus();

    List<Cohort> findAll();

}
