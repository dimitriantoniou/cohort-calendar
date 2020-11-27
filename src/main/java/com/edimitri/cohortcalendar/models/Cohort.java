package com.edimitri.cohortcalendar.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

import static com.edimitri.cohortcalendar.services.CohortCalendarServiceImpl.getHoursOfDayofWeek;

@Entity
@Table(name = "cohorts")
public class Cohort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate gradDate;

    @Column(nullable = false)
    private String programType;

    @Column(nullable = false)
    private String campus;

    @Column(nullable = false)
    @NumberFormat
    private double contactHours;

    public Cohort() {
    }

    public Cohort(String name, LocalDate startDate, String programType, String campus, double contactHours) {
        this();
        this.name = name;
        this.startDate = startDate;
        this.programType = programType;
        this.campus = campus;
        this.contactHours = contactHours;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public long getCohortId() {
        return id;
    }

    public void setCohortId(int cohortId) {
        this.id = cohortId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public double getContactHours() {
        return contactHours;
    }

    public void setContactHours(double contactHours) {
        this.contactHours = contactHours;
    }


    public LocalDate getGradDate() {
        return gradDate;
    }

    public void setGradDate(LocalDate gradDate) {
        this.gradDate = gradDate;
    }
}